package operaciones;

import datos.Inventario;
import datos.Producto;
import javax.swing.JOptionPane;

public class AjusteInventario extends OperacionInventario{
    
    public AjusteInventario(String producto, int cantidad){
        super(producto,cantidad);
    }
    
    public void validarProducto(Inventario inventario){
        super.validarProducto(inventario,true);
       
    }
    @Override
    public void ejecutar(Inventario inventario){
        validarProducto(inventario);
        
        // Obtener el producto y ajustar la cantidad
        Producto productoExistente = inventario.obtenerProducto(producto);
        productoExistente.actualizarCantidad(cantidad);

        // Confirmación de éxito 
        System.out.println("Ajuste realizado con éxito: " + cantidad + " " + producto + " ajustados.");
        JOptionPane.showMessageDialog(null, "Producto ajustado correctamente");
        
    }
}
