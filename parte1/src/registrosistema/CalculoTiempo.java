package registrosistema;

import java.time.Duration;
import java.time.LocalTime;

public class CalculoTiempo implements CalculadoraTiempo{
    private static final LocalTime ingreso = LocalTime.parse("07:00");
    private static final LocalTime salida = LocalTime.parse("18:00");
    
    
    @Override
    public Duration CalcularTiempoFavor(LocalTime horaIngreso, LocalTime horaSalida) {
        Duration tiempoFavor = Duration.ZERO;

        if (horaIngreso.isBefore(ingreso)) {
            tiempoFavor = tiempoFavor.plus(Duration.between(horaIngreso, ingreso));
        }
        if (horaSalida.isAfter(salida)) {
            tiempoFavor = tiempoFavor.plus(Duration.between(salida, horaSalida));
        }

        return tiempoFavor;
    }
    
    @Override
    public Duration CalcularTiempoContra(LocalTime horaIngreso, LocalTime horaSalida) {
        Duration tiempoContra = Duration.ZERO;

        if (horaIngreso.isAfter(ingreso)) {
            tiempoContra = tiempoContra.plus(Duration.between(ingreso, horaIngreso));
        }
        if (horaSalida.isBefore(salida)) {
            tiempoContra = tiempoContra.plus(Duration.between(horaSalida, salida));
        }

        return tiempoContra;
    }

    
    @Override
    public String CalcularTiempoCompensacion(LocalTime horaIngreso, LocalTime horaSalida) {
        Duration tfavor = CalcularTiempoFavor(horaIngreso, horaSalida);
        Duration tcontra = CalcularTiempoContra(horaIngreso, horaSalida);
        Duration compensacion = tfavor.minus(tcontra);

        boolean negativo = compensacion.isNegative();
        compensacion = compensacion.abs();

        long horas = compensacion.toHours();
        long minutos = compensacion.toMinutes() % 60;

        return String.format("%s%02d:%02d", negativo ? "-" : "+", horas, minutos);
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
