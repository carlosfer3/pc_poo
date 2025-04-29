package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class resumenTransaccion {
    private String codigo;
    private LocalDate fecha;
    private LocalTime horaAntesEntrada; // hMI
    private LocalTime horaDespuesEntrada; // hF
    private LocalTime horaAntesSalida; // Anto
    private LocalTime horaDespuesSalida; // Des
    private String tiempoCompensacion; // TC

    public resumenTransaccion(String codigo, LocalDate fecha, LocalTime horaAntesEntrada,
                               LocalTime horaDespuesEntrada, LocalTime horaAntesSalida,
                               LocalTime horaDespuesSalida) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.horaAntesEntrada = horaAntesEntrada;
        this.horaDespuesEntrada = horaDespuesEntrada;
        this.horaAntesSalida = horaAntesSalida;
        this.horaDespuesSalida = horaDespuesSalida;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraAntesEntrada() {
        return horaAntesEntrada;
    }

    public LocalTime getHoraDespuesEntrada() {
        return horaDespuesEntrada;
    }

    public LocalTime getHoraAntesSalida() {
        return horaAntesSalida;
    }

    public LocalTime getHoraDespuesSalida() {
        return horaDespuesSalida;
    }
}