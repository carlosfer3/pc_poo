package Validacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

public class construirLocalDateTime {

    public static LocalDate construirFecha(JFormattedTextField campoFecha) {
        try {
            String textoFecha = campoFecha.getText().trim();//fecha a convertir
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");//mapa para guiar la conversión
            return LocalDate.parse(textoFecha, formatter); // necesita del texto fecha y del formato
        } catch (DateTimeParseException | NullPointerException e) {
            System.out.println("Error al construir LocalDate: " + e.getMessage());
            return null;
        }
    }

    public static LocalTime construirHora(JSpinner spinnerHora, JSpinner spinnerMinuto) {
        try {
            int hora = (Integer) spinnerHora.getValue();
            int minuto = (Integer) spinnerMinuto.getValue();
            return LocalTime.of(hora, minuto);//convertir a tipo LocalTime
        } catch (NullPointerException | ClassCastException e) {
            System.out.println("Error al construir LocalTime: " + e.getMessage());
            return null;
        }
    }
}

