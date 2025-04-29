package Validacion;

import java.time.LocalTime;

public class validadorHora {

    // Variables configurables para las horas normales
    private static LocalTime horaNormalIngreso = LocalTime.of(7, 0);
    private static LocalTime horaNormalSalida = LocalTime.of(18, 0);

    // Obtener la hora normal de ingreso
    public static LocalTime getHoraNormalIngreso() {
        return horaNormalIngreso;
    }

    // Obtener la hora normal de salida
    public static LocalTime getHoraNormalSalida() {
        return horaNormalSalida;
    }
    // Métodos para actualizar las horas normales
    public static void setHoraNormalIngreso(LocalTime hora) {
        horaNormalIngreso = hora;
    }

    public static void setHoraNormalSalida(LocalTime hora) {
        horaNormalSalida = hora;
    }
    
    // 1. Verificar que la hora de ingreso NO sea después de la hora de salida
    public static boolean validarIngresoAntesDeSalida(LocalTime horaIngreso, LocalTime horaSalida) {
        return horaIngreso.isBefore(horaSalida) || horaIngreso.equals(horaSalida);
    }
    
    // 2. Verificar que la hora de salida NO sea antes que la hora de ingreso
    public static boolean validarSalidaDespuesDeIngreso(LocalTime horaIngreso, LocalTime horaSalida) {
        return horaSalida.isAfter(horaIngreso) || horaSalida.equals(horaIngreso);
    }

    // 3. Verificar que la hora de salida NO sea antes de la hora normal de ingreso
    public static boolean validarSalidaDespuesDeHoraNormalIngreso(LocalTime horaSalida) {
        return horaSalida.isAfter(horaNormalIngreso) || horaSalida.equals(horaNormalIngreso);
    }

    
}
