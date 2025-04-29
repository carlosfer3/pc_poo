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

        // 1. Validar existencia del trabajador directamente en la base de datos
        if (!SistemaRegistro.buscarTrabajador(codigo))
            JOptionPane.showMessageDialog(null, "El trabajador con código " + codigo + " no está registrado.");
            return;
        }

        // 2. Obtener la hora a validar
        LocalTime horaAValidar;
        try {
            if (checkEditable.isSelected()) {
                int h = (Integer) spnHora.getValue();
                int m = (Integer) spnMinuto.getValue();
                horaAValidar = LocalTime.of(h, m);
            } else {
                horaAValidar = LocalTime.now();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al construir la hora: " + e.getMessage());
            return;
        }

        // 3. Determinar si es ingreso o salida
        Registro registro = SistemaRegistro.getInstancia().buscarRegistro(codigo);

        if (registro == null) {
            // 🟢 CASO: Ingreso
            LocalTime horaSalidaReferencia = validadorHora.getHoraNormalSalida();
            if (!validadorHora.validarIngresoAntesDeSalida(horaAValidar, horaSalidaReferencia)) {
                JOptionPane.showMessageDialog(null, "La hora de ingreso no puede ser posterior a la hora de salida normal.");
                return;
            }
            System.out.println("✓ Validación de ingreso exitosa para " + codigo);
        } else {
            // 🔵 CASO: Salida
            LocalTime horaIngreso = registro.getHoraIngreso();
            if (horaIngreso == null) {
                JOptionPane.showMessageDialog(null, "Error: No se puede registrar salida sin haber registrado ingreso.");
                return;
            }
            if (!validadorHora.validarSalidaDespuesDeIngreso(horaIngreso, horaAValidar)) {
                JOptionPane.showMessageDialog(null, "La hora de salida debe ser posterior a la hora de ingreso.");
                return;
            }
            if (!validadorHora.validarSalidaDespuesDeHoraNormalIngreso(horaAValidar)) {
                JOptionPane.showMessageDialog(null, "La hora de salida no puede ser antes de la hora normal de ingreso.");
                return;
            }
            System.out.println("✓ Validación de salida exitosa para " + codigo);
        }
    }
}