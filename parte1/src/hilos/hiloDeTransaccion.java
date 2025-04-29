package hilos;

import java.time.LocalTime;
import java.time.LocalDate;
import registrosistema.SistemaRegistro;
import registrosistema.Registro;

public class hiloDeTransaccion extends Thread {

    private String codigo;
    private LocalTime horaValidada;

    public hiloDeTransaccion(String codigo, LocalTime horaValidada) {
        this.codigo = codigo;
        this.horaValidada = horaValidada;
    }

    @Override
    public void run() {
        SistemaRegistro sistema = SistemaRegistro.getInstancia();//llamamos al sistema de registro

        // Ver si el trabajador ya tiene un registro (verifica entrada previa)
        Registro registroExistente = sistema.buscarRegistro(codigo);

        if (registroExistente == null) {
            // 🟢 CASO ENTRADA: nuevo registro
            LocalDate fechaActual = LocalDate.now();//trae la fecha del sistema
            sistema.registrarEntrada(codigo, fechaActual, horaValidada);
            System.out.println("✓ Entrada registrada exitosamente para " + codigo + " a las " + horaValidada);

        } else {
            // 🔵 CASO SALIDA: completar registro
            sistema.registrarSalida(codigo, horaValidada);
            System.out.println("✓ Salida registrada exitosamente para " + codigo + " a las " + horaValidada);
        }
    }
}