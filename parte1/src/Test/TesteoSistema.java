package Test;

import registrosistema.SistemaRegistro;
import registrosistema.Trabajador;

public class TesteoSistema {
    private SistemaRegistro sistema = SistemaRegistro.getInstancia();
    private GeneradorDeTrabajador generadortrabajador = new GeneradorTrabajadorBasico();
    
    public void TestearTrabajadores() {
        for(int i = 0; i < 10; i++) {
            Trabajador t = generadortrabajador.generarTrabajador();
            sistema.agregarTrabajador(t);
        }
    }
    
    public void TestearTrabajadoresInternos() {
        String codigo1 = "20231172f";
        String codigo2 = "20232571a";
        String codigo3 = "20231314e";
        
        Trabajador t1 = new Trabajador(codigo1);
        Trabajador t2 = new Trabajador(codigo2);
        Trabajador t3 = new Trabajador(codigo3);
        
        sistema.agregarTrabajador(t1);
        sistema.agregarTrabajador(t2);
        sistema.agregarTrabajador(t3);
    }
    
}
