package Reporte;

import registrosistema.SistemaRegistro;
import registrosistema.CalculoTiempo;
import registrosistema.Registro;
import registrosistema.CalculadoraTiempo;

import javax.swing.*;
import java.util.List;

public class generadorReporteSwing implements generadorReporte{
    private JFrame frame;
    
     public generadorReporteSwing(JFrame frame) {
        this.frame = frame;
    }
     
    @Override
    public void generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("📋 REPORTE DE COMPENSACIÓN\n\n");
        
        CalculadoraTiempo calculador = new CalculoTiempo();//necesario para usar el metodo CalcularTiempoCompensacion porque hicimos el @override y no es un metodo statico

        List<Registro> registros = SistemaRegistro.getInstancia().obtenerRegistros();
        
        for (Registro r : registros) {
            if (r.getHoraIngreso() != null && r.getHoraSalida() != null) {
                String tc = calculador.CalcularTiempoCompensacion(r.getHoraIngreso(), r.getHoraSalida());
                reporte.append("Código: ").append(r.getTrabajador().getCodigo()).append("\n");
                reporte.append("Fecha: ").append(r.getFecha()).append("\n");
                reporte.append("Hora Ingreso: ").append(r.getHoraIngreso()).append("\n");
                reporte.append("Hora Salida: ").append(r.getHoraSalida()).append("\n");
                reporte.append("Tiempo de Compensación: ").append(tc).append("\n");
                reporte.append("----------------------------\n");
            }
        }

        JTextArea textArea = new JTextArea(reporte.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

        JOptionPane.showMessageDialog(frame, scrollPane, "REPORTE FINAL", JOptionPane.INFORMATION_MESSAGE);
    }
     
}
