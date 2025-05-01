package operaciones;

import datos.Inventario;
import datos.Producto;
import javax.swing.JOptionPane;

public class TransferenciaInventario extends OperacionInventario {
    private Inventario inventarioDestino;
    
    public TransferenciaInventario(String producto, int cantidad, Inventario InventarioDestino){
        super(producto, cantidad);
        this.inventarioDestino = InventarioDestino;
    }
    
    public void validarProducto(Inventario inventario){
        super.validarProducto(inventario, true); 
        
        Producto productoExistente = inventario.obtenerProducto(producto);
        if(productoExistente.getCantidad() < cantidad){
            JOptionPane.showMessageDialog(null, "No hay sufciente cantidad para transferir.");
            throw new IllegalArgumentException();
        }
    }
    @Override
    public void ejecutar(Inventario inventario){
        validarProducto(inventario);
        
        // Obtener el producto en el inventario origen
        Producto productoExistente = inventario.obtenerProducto(producto);
        
        // Reducir la cantidad del producto en el inventario origen
        productoExistente.actualizarCantidad(productoExistente.getCantidad()- cantidad);
        
        Producto productoDestino = inventarioDestino.obtenerProducto(producto);
        if (productoDestino != null){
            productoDestino.actualizarCantidad(productoDestino.getCantidad() + cantidad);
        } else {
            inventarioDestino.agregarProducto(producto, cantidad);
        }
        
        JOptionPane.showMessageDialog(null, "Transferencia realizada con exito.");
        
    }
    
}
