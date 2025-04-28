package registrodeacceso;

/**
 * @author HENRY MEDINA
 */
public class RegistroDeAcceso {
    public static void main(String[] args) {
        // Esto asegura que la interfaz gráfica se muestre correctamente en el hilo de Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroDeAcceso().setVisible(true);
            }
        });
    }
}