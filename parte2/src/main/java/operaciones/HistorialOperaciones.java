package operaciones;

import java.util.ArrayList;
import java.util.List;

public class HistorialOperaciones {
    private List<String> historial = new ArrayList<>();
    
    public void agregarOperacion(String operacion){
        historial.add(operacion);
    }
    
    public List<String> obtenerHistorial(){
        return historial;
    }
}
