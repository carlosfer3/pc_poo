package Validacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

public class construirLocalDateTime {

    public static LocalDateTime construirDesdeComponentes(
            JFormattedTextField campoFecha, JSpinner spinnerHora, JSpinner spinnerMinuto) {

        try {
            // Obtenemos el texto de la fecha
            String textoFecha = campoFecha.getText().trim();
            
            // Formato esperado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate fecha = LocalDate.parse(textoFecha, formatter);
            
            // Obtenemos los valores numéricos de los spinner
            int hora = (Integer) spinnerHora.getValue();
            int minuto = (Integer) spinnerMinuto.getValue();
            
            LocalTime tiempo = LocalTime.of(hora, minuto);
            return LocalDateTime.of(fecha, tiempo);
        } catch (DateTimeParseException | NullPointerException | ClassCastException e) {
            System.out.println("Error al construir LocalDateTime: " + e.getMessage());
            return null;
        }
    }
}
