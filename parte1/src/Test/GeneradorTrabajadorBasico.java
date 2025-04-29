package Test;

import registrosistema.Trabajador;

public class GeneradorTrabajadorBasico implements GeneradorDeTrabajador{
    private GeneradorDeCodigo generadorcodigo = new GeneradorCodigoAutomatico();
    
    @Override
    public Trabajador generarTrabajador() {
        String codigo = generadorcodigo.generarCodigo();
        return new Trabajador(codigo);
    }
}
