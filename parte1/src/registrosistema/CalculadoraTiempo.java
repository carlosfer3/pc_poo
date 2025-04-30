package registrosistema;

import java.time.Duration;
import java.time.LocalTime;

public interface CalculadoraTiempo {
    public LocalTime CalcularTiempoFavor(LocalTime horaIngreso);
    
    public LocalTime CalcularTiempoContra(LocalTime horaSalida);
    
    public String CalcularTiempoCompensacion(LocalTime horaIngreso, LocalTime horaSalida);
}
