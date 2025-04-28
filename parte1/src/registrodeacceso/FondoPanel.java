package registrodeacceso;

import java.awt.*;
import javax.swing.*;

public class FondoPanel extends JPanel {
    private Image imagen;

    // Constructor: recibe la ruta de la imagen
    public FondoPanel(String rutaImagen) {
        imagen = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen escalada al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
