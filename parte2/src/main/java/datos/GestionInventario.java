package datos;

import java.util.List;

public interface GestionInventario {
    void agregarProducto(String nombre, int cantidad);
    Producto obtenerProducto(String nombre);
    List<Producto> obtenerProductos();
    void realizarOperacion(String nombre, int cantidad);
    
}
