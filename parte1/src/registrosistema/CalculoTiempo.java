package registrosistema;

import java.time.Duration;
import java.time.LocalTime;

public class CalculoTiempo {
    private static final LocalTime ingreso = LocalTime.parse("07:00");
    private static final LocalTime salida = LocalTime.parse("18:00");
    
    /*
    public static LocalTime CalcularTiempoFavor(LocalTime horaIngreso) {
        Duration duration = Duration.between(ingreso, horaIngreso).abs();
        long horas = duration.toHours();
        long minutos = duration.toMinutes() % 60;
        return LocalTime.of((int) horas, (int) minutos);
    }

    public static LocalTime CalcularTiempoContra(LocalTime horaSalida) {
        Duration duration = Duration.between(salida, horaSalida).abs();
        long horas = duration.toHours();
        long minutos = duration.toMinutes() % 60;
        return LocalTime.of((int) horas, (int) minutos);
    }

    public static String CalcularTiempoCompensacion(LocalTime horaIngreso, LocalTime horaSalida) {
        LocalTime tfavor = CalcularTiempoFavor(horaIngreso);
        LocalTime tcontra = CalcularTiempoContra(horaSalida);
        Duration duracion = Duration.between(tcontra, tfavor); // TF - TC
        boolean esNegativo = duracion.isNegative();
        duracion = duracion.abs();
        long horas = duracion.toHours();
        long minutos = duracion.toMinutes() % 60;
        return String.format("%s%02d:%02d", esNegativo ? "-" : "", horas, minutos);
    }
    */
    public static String CalcularTiempoCompensacion(LocalTime horaIngreso, LocalTime horaSalida) {
        Duration tiempoEsperado = Duration.between(ingreso, salida);
        Duration tiempoReal = Duration.between(horaIngreso, horaSalida);
        Duration compensacion = tiempoReal.minus(tiempoEsperado);

        boolean esNegativo = compensacion.isNegative();
        compensacion = compensacion.abs();

        long horas = compensacion.toHours();
        long minutos = compensacion.toMinutes() % 60;

        return String.format("%s%02d:%02d", esNegativo ? "-" : "+", horas, minutos);
    }

    public static LocalTime getHoraNormalIngreso() {
        return ingreso;
    }

    public static LocalTime getHoraNormalSalida() {
        return salida;
    }

    public static LocalTime getDiferenciaAntes(LocalTime referencia, LocalTime actual) {
        if (actual.isBefore(referencia)) {//si la diferencia no es positiva entonces por defecto es 0:00
            Duration d = Duration.between(actual, referencia);
            return LocalTime.of((int) d.toHours(), (int) (d.toMinutes() % 60));
        }
        return LocalTime.of(0, 0);
    }

    public static LocalTime getDiferenciaDespues(LocalTime referencia, LocalTime actual) {
        if (actual.isAfter(referencia)) {//si la diferencia no es positiva entonces por defecto es 0:00
            Duration d = Duration.between(referencia, actual);
            return LocalTime.of((int) d.toHours(), (int) (d.toMinutes() % 60));
        }
        return LocalTime.of(0, 0);
    }
} 
