package hilos;

import modelo.resumenTransaccion;
import registrosistema.CalculoTiempo;
import registrosistema.Registro;
import registrosistema.SistemaRegistro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class hiloDeTransaccion extends Thread {
    private String codigo;
    private LocalTime horaValidada;
    private JTable tabla;
    private List<resumenTransaccion> listaResumen;

    public hiloDeTransaccion(String codigo, LocalTime horaValidada, JTable tabla, List<resumenTransaccion> listaResumen) {
        this.codigo = codigo;
        this.horaValidada = horaValidada;
        this.tabla = tabla;
        this.listaResumen = listaResumen;
    }

    @Override
    public void run() {
        SistemaRegistro sistema = SistemaRegistro.getInstancia();//llamamos al sistema de registro
        Registro registroExistente = sistema.buscarRegistro(codigo);//buscamos si el trabajador ingreso o no suponiendo que si exite en la base de datos
        LocalDate fechaActual = LocalDate.now();//fijamos la fecha actual

        LocalTime hMI = null, hF = null, Anto = null, Des = null;

        if (registroExistente == null) {
            // 🟢 Caso entrada
            sistema.registrarEntrada(codigo, fechaActual, horaValidada);

            LocalTime antes = CalculoTiempo.getDiferenciaAntes(CalculoTiempo.getHoraNormalIngreso(), horaValidada);//vemos si es antes de la hora de ingreso normal
            LocalTime despues = CalculoTiempo.getDiferenciaDespues(CalculoTiempo.getHoraNormalIngreso(), horaValidada);//vemos si es despeus de la hora de ingreso normal

            hMI = !antes.equals(LocalTime.of(0, 0)) ? antes : null;
            hF = !despues.equals(LocalTime.of(0, 0)) ? despues : null;

            resumenTransaccion resumen = new resumenTransaccion(codigo, fechaActual, hMI, hF, null, null);
            listaResumen.add(resumen);

            SwingUtilities.invokeLater(() -> {
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                model.addRow(new Object[]{codigo, fechaActual, hMI != null ? hMI.toString() : "-", hF != null ? hF.toString() : "-", "-", "-"});
            });

            System.out.println("✓ Entrada registrada exitosamente para " + codigo + " a las " + horaValidada);

        } else {
            // 🔵 Caso salida
            sistema.registrarSalida(codigo, horaValidada);

            LocalTime antes = CalculoTiempo.getDiferenciaAntes(CalculoTiempo.getHoraNormalSalida(), horaValidada);
            LocalTime despues = CalculoTiempo.getDiferenciaDespues(CalculoTiempo.getHoraNormalSalida(), horaValidada);

            Anto = !antes.equals(LocalTime.of(0, 0)) ? antes : null;
            Des = !despues.equals(LocalTime.of(0, 0)) ? despues : null;

            resumenTransaccion resumen = new resumenTransaccion(codigo, fechaActual, null, null, Anto, Des);
            listaResumen.add(resumen);

            SwingUtilities.invokeLater(() -> {
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                model.addRow(new Object[]{codigo, fechaActual, "-", "-", Anto != null ? Anto.toString() : "-", Des != null ? Des.toString() : "-"});
            });

            System.out.println("✓ Salida registrada exitosamente para " + codigo + " a las " + horaValidada);
        }
    }
}