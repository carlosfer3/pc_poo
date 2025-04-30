package registrosistema;

import java.time.Duration;
import java.time.LocalTime;

public interface CalculadoraTiempo {
    public Duration CalcularTiempoFavor(LocalTime horaIngreso,LocalTime horaSalida);
    
    public Duration CalcularTiempoContra(LocalTime horaIngreso,LocalTime horaSalida);
    
    public String CalcularTiempoCompensacion(LocalTime horaIngreso, LocalTime horaSalida);
}
