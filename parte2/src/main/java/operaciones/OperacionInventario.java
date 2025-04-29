package operaciones;

import datos.Inventario;
import datos.Producto;

public abstract class OperacionInventario {
    protected String producto;
    protected int cantidad;
    
    public OperacionInventario(String producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }  
    
    // Metodo para validaciones
    protected void validarProducto(Inventario inventario){
        if(producto == null || producto.isEmpty()){
            throw new IllegalArgumentException("El producto es nulo o no existe");
        }
        
        Producto productoExistente = inventario.obtenerProducto(producto);
        if (productoExistente == null) {
            throw new IllegalArgumentException("Producto no encontrado en el inventario.");
        }
        
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
    }
    
    // Metodo abstracto que cada operacion debera implementar
    public abstract void ejecutar(Inventario inventario);
}
