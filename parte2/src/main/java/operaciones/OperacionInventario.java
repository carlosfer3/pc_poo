package operaciones;

import datos.Inventario;
import datos.Producto;
import javax.swing.JOptionPane;

public abstract class OperacionInventario {
    protected String producto;
    protected int cantidad;
    
    public OperacionInventario(String producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }  
    
    // Metodo para validaciones
    public void validarProducto(Inventario inventario, boolean verificarExistencia){
        
        Producto productoExistente = inventario.obtenerProducto(producto);
        
        if (verificarExistencia){
            if (productoExistente == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
            throw new IllegalArgumentException();
            }
        }else {
            if (productoExistente != null){
                JOptionPane.showMessageDialog(null, "Este producto ya existe en el inventario.");
                throw new IllegalArgumentException();
            }
        }
        
        // Validar que la cantidad sea mayor que 0
        if (cantidad < 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero.");
            throw new IllegalArgumentException();
        }
        
    }
    
    // Metodo abstracto que cada operacion debera implementar
    public abstract void ejecutar(Inventario inventario);
}
