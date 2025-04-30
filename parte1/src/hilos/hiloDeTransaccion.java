// Reestructura del hiloDeTransaccion sin resumenTransaccion
package hilos;

import registrosistema.CalculoTiempo;
import registrosistema.Registro;
import registrosistema.SistemaRegistro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;

public class hiloDeTransaccion extends Thread {
    private String codigo;
    private LocalTime horaValidada;
    private JTable tabla;

    public hiloDeTransaccion(String codigo, LocalTime horaValidada, JTable tabla) {
        this.codigo = codigo;
        this.horaValidada = horaValidada;
        this.tabla = tabla;
    }

    @Override
    public void run() {
        SistemaRegistro sistema = SistemaRegistro.getInstancia();
        Registro registroExistente = sistema.buscarRegistro(codigo);
        LocalDate fechaActual = LocalDate.now();

        if (registroExistente == null) {
            // 🟢 Caso entrada
            sistema.marcarEntrada(codigo, fechaActual, horaValidada);

        } else {
            // 🔵 Caso salida
            sistema.marcarSalida(codigo, horaValidada);
            sistema.agregarTC(codigo, sistema.buscarRegistro(codigo));
        }

        // Actualizamos el modelo de la tabla directamente desde SistemaRegistro
        SwingUtilities.invokeLater(() -> {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);

            for (Registro r : sistema.obtenerRegistros()) {
                if (r.getFecha().equals(fechaActual)) {
                    LocalTime hMI = CalculoTiempo.getDiferenciaAntes(CalculoTiempo.getHoraNormalIngreso(), r.getHoraIngreso());
                    LocalTime hF = CalculoTiempo.getDiferenciaDespues(CalculoTiempo.getHoraNormalIngreso(), r.getHoraIngreso());

                    LocalTime Anto = r.getHoraSalida() != null ?
                            CalculoTiempo.getDiferenciaAntes(CalculoTiempo.getHoraNormalSalida(), r.getHoraSalida()) : null;
                    LocalTime Des = r.getHoraSalida() != null ?
                            CalculoTiempo.getDiferenciaDespues(CalculoTiempo.getHoraNormalSalida(), r.getHoraSalida()) : null;

                    String tf = (Anto != null && !Anto.equals(LocalTime.of(0, 0))) ? Anto.toString() : "-";
                    String tc = (Des != null && !Des.equals(LocalTime.of(0, 0))) ? Des.toString() : "-";
                    
                    model.addRow(new Object[]{
                            r.getTrabajador().getCodigo(),
                            r.getFecha(),
                            !hMI.equals(LocalTime.of(0, 0)) ? hMI.toString() : "-",
                            !hF.equals(LocalTime.of(0, 0)) ? hF.toString() : "-",
                            tf,
                            tc
                    });
                }
            }
        });
    }
}
