package registrosistema;

import java.time.LocalDate;
import java.time.LocalTime;

public class SistemaRegistro {
    private static SistemaRegistro instance;
    private RepositorioRegistros repositorio;

    private SistemaRegistro() {
        repositorio = new RepositorioRegistros();
    }

    public static synchronized SistemaRegistro getInstance() {
        if (instance == null) {
            instance = new SistemaRegistro();
        }
        return instance;
    }

    public synchronized void registrarEntrada(String codigo, LocalDate fecha, LocalTime hora) {
        Trabajador t = new Trabajador(codigo);
        Registro r = new Registro(t, fecha, hora);
        
        repositorio.agregarRegistro(r);
    }
    
    public synchronized void registrarSalida(String codigo, LocalTime hora) {
        Registro r = repositorio.buscarRegistro(codigo);
        r.AgregarHoraSalida(hora);
    }
}
