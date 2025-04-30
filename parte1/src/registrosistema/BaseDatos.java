package registrosistema;

import java.util.List;
import java.util.ArrayList;

public class BaseDatos implements RepositorioDeTrabajadores{
    private List<Trabajador> trabajadores = new ArrayList<>();

    //APLICAR EN EL TEST PARA GUARDAR TRABAJADORES EN LA BASE DE DATOS
    @Override
    public synchronized void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    //Para la validaciaon, si es que el trabajador se encuentra en la base de datos entonces botara true, de lo contrario false
    @Override
    public synchronized boolean buscarTrabajador(String codigo) {
        for (Trabajador t : trabajadores) {
            if (t.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public void mostrarTrabajadores() {
        for(Trabajador t : trabajadores) {
            System.out.println(t.getCodigo());
        }
    }
}
