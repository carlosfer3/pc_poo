package operaciones;

import datos.Inventario;
import datos.Producto;

public class TransferenciaInventario extends OperacionInventario {
    private Inventario inventarioDestino;
    
    public TransferenciaInventario(String producto, int cantidad, Inventario destino){
        super(producto, cantidad);
        this.inventarioDestino = destino;
    }
    
    @Override
    public void ejecutar(Inventario inventarioOrigen){
        validarProducto(inventarioOrigen);
        
        // Verificar si hay suficiente cantidad en el inventario de origen
        Producto productoExistente = inventarioOrigen.obtenerProducto(producto);
        if (productoExistente.getCantidad() < cantidad) {
            throw new IllegalArgumentException("No hay suficiente cantidad del producto en el inventario de origen.");
        }

        // Transferir el producto entre inventarios
        productoExistente.actualizarCantidad(-cantidad);
        Producto productoDestino = inventarioDestino.obtenerProducto(producto);
        if (productoDestino == null) {
            inventarioDestino.agregarProducto(producto, cantidad);
        } else {
            productoDestino.actualizarCantidad(cantidad);
        }
        
    }
    
}
