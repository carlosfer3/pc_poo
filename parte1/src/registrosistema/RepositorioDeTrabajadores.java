package registrosistema;

public interface RepositorioDeTrabajadores {
    void agregarTrabajador(Trabajador t);
    boolean buscarTrabajador(String codigo);
}
