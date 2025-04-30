package operaciones;

import datos.Inventario;
import datos.Producto;
import javax.swing.JOptionPane;

public class AgregarInventario extends OperacionInventario {
    
    public AgregarInventario(String producto,int cantidad){
        super(producto,cantidad);
    }
    
    @Override
    public void validarProducto(Inventario inventario,boolean verificarExistencia){
        super.validarProducto(inventario,verificarExistencia);
        
        if (cantidad == 0){
            JOptionPane.showMessageDialog(null, "La cantidad no puede ser 0");
            throw new IllegalArgumentException();
        }
    }
    @Override
    public void ejecutar(Inventario inventario){
        
        validarProducto(inventario,false);
        inventario.agregarProducto(producto, cantidad);
        System.out.println("Producto: " + producto + " agregado al inventario.");
        JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
    }
}
