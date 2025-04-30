package registrosistema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {
    private Trabajador trabajador;
    private final LocalDate fecha;
    private final LocalTime horaIngreso;
    private LocalTime horaSalida;

    public Registro(Trabajador trabajador, LocalDate fecha, LocalTime horaIngreso) {
        this.trabajador = trabajador;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
    }
    
    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void AgregarHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
