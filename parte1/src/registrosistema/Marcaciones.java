package registrosistema;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Marcaciones {
    public void marcarEntrada(String codigo, LocalDate fecha, LocalTime hora);
    
    public void marcarSalida(String codigo, LocalTime hora);
}
