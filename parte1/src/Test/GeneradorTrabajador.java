package Test;

import registrosistema.Trabajador;

public class GeneradorTrabajador {
    public static Trabajador generarTrabajador() {
        String codigo = GeneradorCodigo.generarCodigo();
        return new Trabajador(codigo);
    }
}
