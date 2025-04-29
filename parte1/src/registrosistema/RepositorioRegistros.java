package registrosistema;

import java.util.List;
import java.util.ArrayList;

public class RepositorioRegistros {
    private List<Registro> registros = new ArrayList<>();
    private List<Trabajador> trabajadores = new ArrayList<>();
    
    public void agregarRegistro(Registro registro) {
        registros.add(registro);
    }
    public List<Registro> obtenerTodosRegistros() {
        return registros;
    }

    //APLICAR EN EL TEST PARA GUARDAR TRABAJADORES EN LA BASE DE DATOS
    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    //Para la validaciaon, si es que el trabajador se encuentra en la base de datos entonces botara true, de lo contrario false
    public boolean buscarTrabajador(String codigo) {
        for (Trabajador t : trabajadores) {
            if (t.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public Registro buscarRegistro(String codigo) {
        for (Registro r: registros) {
            Trabajador t = r.getTrabajador();
            if(codigo.equals(t.getCodigo())) {
                return r;
            }
        }
        
        return null;
    }
}
