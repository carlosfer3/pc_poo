package operaciones;

import datos.Inventario;
import datos.Producto;

public class AgregarInventario extends OperacionInventario {
    
    public AgregarInventario(String producto,int cantidad){
        super(producto,cantidad);
    }
    
    @Override
    public void ejecutar(Inventario inventario){

        // Verificar si el producto existe
        Producto productoExistente = inventario.obtenerProducto(producto);
        if (productoExistente != null) {
            // Si el producto existe, no se agrega
            System.out.println("El producto '" + producto + "' ya existe en el inventario.");
            return;
        } 
        
        inventario.agregarProducto(producto, cantidad);
        System.out.println("Producto: " + producto + " agregado al inventario.");
    }
}
