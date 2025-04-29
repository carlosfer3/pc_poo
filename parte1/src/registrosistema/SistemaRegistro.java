package registrosistema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaRegistro {
    private static SistemaRegistro instancia;
    private BaseDatos db = new BaseDatos();
    private List<Registro> registros = new ArrayList<>();
    private Map<String, String> tcompensacion = new HashMap<>();

    private SistemaRegistro() {}

    public static synchronized SistemaRegistro getInstancia() {
        if (instancia == null) {
            instancia = new SistemaRegistro();
        }
        return instancia;
    }

    /*
    API
    */
    public synchronized void agregarTrabajador(Trabajador trabajador) {
        db.agregarTrabajador(trabajador);
    }
    
    public synchronized boolean buscarTrabajador(String codigo) {
        return db.buscarTrabajador(codigo);
    }
    
    public void mostrarTrabajadores() {
        db.mostrarTrabajadores();
    }
    /*
    API
    */
    
    public synchronized void agregarRegistro(Registro r) {
        registros.add(r);
    }
    
    public synchronized Registro buscarRegistro(String codigo) {
        for(Registro r : registros) {
            Trabajador t = r.getTrabajador();
            if(t.getCodigo().equals(codigo)) {
                return r;
            }
        }
        
        return null;
    }
    
    public synchronized void registrarEntrada(String codigo, LocalDate fecha, LocalTime hora) {
        Trabajador t = new Trabajador(codigo);
        Registro r = new Registro(t, fecha, hora);
        
        agregarRegistro(r);
    }
    
    public synchronized void registrarSalida(String codigo, LocalTime hora) {
        Registro r = buscarRegistro(codigo);
        r.AgregarHoraSalida(hora);
        
    }
    public synchronized void agregarTC(String codigo, Registro r) {
        LocalTime horaIngreso = r.getHoraIngreso();
        LocalTime horaSalida = r.getHoraSalida();
        
        String tc = CalculoTiempo.CalcularTiempoCompensacion(horaIngreso, horaSalida);
        tcompensacion.put(codigo, tc);
    }
    
}
