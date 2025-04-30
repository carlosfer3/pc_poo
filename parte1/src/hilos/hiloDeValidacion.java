package hilos;

import javax.swing.*;
import java.time.LocalTime;
import Validacion.validadorHora;
import registrosistema.SistemaRegistro;
import registrosistema.Registro;

public class hiloDeValidacion extends Thread {

    private JTextField txtCodigo;
    private JCheckBox checkEditable;
    private JSpinner spnHora;
    private JSpinner spnMinuto;

    public hiloDeValidacion(JTextField txtCodigo, JCheckBox checkEditable, JSpinner spnHora, JSpinner spnMinuto) {
        this.txtCodigo = txtCodigo;
        this.checkEditable = checkEditable;
        this.spnHora = spnHora;
        this.spnMinuto = spnMinuto;
    }

    @Override
    public void run() {
        String codigo = txtCodigo.getText().trim();

        // 1. Validar existencia del trabajador
        if (!SistemaRegistro.getInstancia().buscarTrabajador(codigo)) {
            JOptionPane.showMessageDialog(null, "El trabajador con código " + codigo + " no está registrado.");
            return;
        }

        // 2. Obtener hora
        LocalTime horaAValidar;
        try {
            if (checkEditable.isSelected()) {
                int h = (Integer) spnHora.getValue();
                int m = (Integer) spnMinuto.getValue();
                horaAValidar = LocalTime.of(h, m);//trae la hora manual
            } else {
                horaAValidar = LocalTime.now();//trae hora del sistema
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al construir la hora: " + e.getMessage());
            return;
        }

        // 3. Buscar registro
        Registro registro = SistemaRegistro.getInstancia().buscarRegistro(codigo);//ve si marco asistencia el usuario

        if (registro == null) {
            // 🟢 Caso: ingreso
            LocalTime horaSalidaReferencia = validadorHora.getHoraNormalSalida();//trae la hora de salida normal para la validación
            if (!validadorHora.validarIngresoAntesDeSalida(horaAValidar, horaSalidaReferencia)) {
                JOptionPane.showMessageDialog(null, "La hora de ingreso no puede ser posterior a la hora de salida normal.");
                return;
            }
            System.out.println("✓ Validación de ingreso exitosa para " + codigo);
        } else {
            // 🔵 Caso: salida
            LocalTime horaIngreso = registro.getHoraIngreso();//trae la hora de ingreso registrada
            if (horaIngreso == null) {
                JOptionPane.showMessageDialog(null, "Error: No se puede registrar salida sin ingreso previo.");
                return;
            }
            if (!validadorHora.validarSalidaDespuesDeIngreso(horaIngreso, horaAValidar)) {
                JOptionPane.showMessageDialog(null, "La hora de salida debe ser posterior a la hora de ingreso.");
                return;
            }
            if (!validadorHora.validarSalidaDespuesDeHoraNormalIngreso(horaAValidar)) {
                JOptionPane.showMessageDialog(null, "La hora de salida debe ser después de la hora normal de ingreso.");
                return;
            }
            System.out.println("✓ Validación de salida exitosa para " + codigo);
        }
    }
}