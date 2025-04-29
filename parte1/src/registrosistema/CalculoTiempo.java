package registrosistema;

import java.time.Duration;
import java.time.LocalTime;

public class CalculoTiempo implements CalculadoraTiempo{
    private static final LocalTime ingreso = LocalTime.parse("07:00");
    private static final LocalTime salida = LocalTime.parse("18:00");
    
    @Override
    public LocalTime CalcularTiempoFavor(LocalTime horaIngreso) {
        Duration duration = Duration.between(ingreso, horaIngreso);
        
        long horas = duration.toHours();
        long minutos = duration.toMinutes() % 60;

        return LocalTime.of((int) horas, (int) minutos);
    }
    
    @Override
    public LocalTime CalcularTiempoContra(LocalTime horaSalida) {
        Duration duration = Duration.between(salida, horaSalida);
        
        long horas = duration.toHours();
        long minutos = duration.toMinutes() % 60;

        return LocalTime.of((int) horas, (int) minutos);
    }
    
    @Override
    public String CalcularTiempoCompensacion(LocalTime horaIngreso, LocalTime horaSalida) {
        LocalTime tfavor = CalcularTiempoFavor(horaIngreso);
        LocalTime tcontra = CalcularTiempoContra(horaSalida);
        
        Duration duracion = Duration.between(tfavor, tcontra);
        boolean esNegativo = duracion.isNegative();
        duracion = duracion.abs();
        long horas = duracion.toHours();
        long minutos = duracion.toMinutes() % 60;

        return String.format("%s%02d:%02d", esNegativo ? "-" : "", horas, minutos);
    }
    
}
