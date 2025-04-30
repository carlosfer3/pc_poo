package hilos;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.time.LocalTime;
import Validacion.construirLocalDateTime;
import Validacion.validadorHora;
import registrosistema.SistemaRegistro;
import registrosistema.Registro;


public class hiloDeValidacion extends Thread {

    private JTextField txtCodigo;
    private JCheckBox checkEditable;
    private JSpinner spnHora;
    private JSpinner spnMinuto;
    
    private boolean validacionExitosa = false;
    private String codigo;
    private LocalTime horaValidada;

    public hiloDeValidacion(JTextField txtCodigo, JCheckBox checkEditable, JSpinner spnHora, JSpinner spnMinuto) {
        this.txtCodigo = txtCodigo;
        this.checkEditable = checkEditable;
        this.spnHora = spnHora;
        this.spnMinuto = spnMinuto;
    }

    @Override
    public void run() {
        System.out.println("inicio del hilo de validacion");
        
        String codigo = txtCodigo.getText().trim();

        // 1. Validar existencia del trabajador
        if (!SistemaRegistro.getInstancia().buscarTrabajador(codigo)) {
            System.out.println("Trabajador no encontrado");
            SwingUtilities.invokeLater(() -> {//necesario para que se muestre el mensaje emergente
                JOptionPane.showMessageDialog(null, "El trabajador con código " + codigo + " no está registrado.");
            });
            return;
        }
        System.out.println("Trabajador encontrado");
        
        
        // 2. Obtener hora
        LocalTime horaAValidar;
        try {
            if (checkEditable.isSelected()) {
                horaAValidar = construirLocalDateTime.construirHora(spnHora, spnMinuto);//converitr los spinner a hora 
            } else {
                horaAValidar = LocalTime.now();//trae hora del sistema
            }
        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> {
                System.out.println("Hora de salida no exitosa");
                JOptionPane.showMessageDialog(null, "Error al construir la hora: " + e.getMessage()); 
            });
            return;
        }
        System.out.println("Hora validada");
        
        // 3. Buscar registro
        Registro registro = SistemaRegistro.getInstancia().buscarRegistro(codigo);//ve si marco asistencia el usuario

        if (registro == null) {
            // 🟢 Caso: ingreso
            LocalTime horaSalidaReferencia = validadorHora.getHoraNormalSalida();//trae la hora de salida normal para la validación
            if (!validadorHora.validarIngresoAntesDeSalida(horaAValidar, horaSalidaReferencia)) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "La hora de ingreso no puede ser posterior a la hora de salida normal.");
                    System.out.println("Error en validacion hora de ingreso no puede ser posterior a la hora de salida normal");
                });
                return;
            }
            
            System.out.println("✓ Validación de ingreso exitosa para " + codigo);
            validacionExitosa = true;
            this.codigo = codigo;
            this.horaValidada = horaAValidar;

        } else {
            // 🔵 Caso: salida
            LocalTime horaIngreso = registro.getHoraIngreso();//trae la hora de ingreso registrada
            
            if (!validadorHora.validarSalidaDespuesDeIngreso(horaIngreso, horaAValidar)) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "La hora de salida debe ser antes a la hora de ingreso.");
                    System.out.println("Error en la validacion hora de salida debe ser antes a la hora de ingreso");
                });
                return;
            }
            if (!validadorHora.validarSalidaDespuesDeHoraNormalIngreso(horaAValidar)) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "La hora de salida debe ser después de la hora normal de ingreso.");
                    System.out.println("Error en la validacion la hora de salida no puede ser despues de la hora normal de ingreso");
                });
                return;
            }
            
            System.out.println("✓ Validación de salida exitosa para " + codigo);
            validacionExitosa = true;
            this.codigo = codigo;
            this.horaValidada = horaAValidar;
        }
    }
    //metodos par apoder extraer lo validado
    public boolean esValido() {
        return validacionExitosa;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalTime getHoraValidada() {
        return horaValidada;
    }

}