package datos;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Inventario implements GestionInventario{
    
    private Map<String,Producto> productos = new HashMap<>();
    private Lock lock = new ReentrantLock();  //Lock para sincronizacion
    
    // Metodo para agregar un producto
    @Override
    public void agregarProducto(String nombre, int cantidad){
        lock.lock();
        try{
            productos.put(nombre,new Producto(nombre,cantidad));
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public Producto obtenerProducto(String nombre){
        lock.lock();
        try{
            return productos.get(nombre);
        }finally {
            lock.unlock();
        }
    }
    
    @Override
    public List<Producto> obtenerProductos() {
        lock.lock();
        try {
            return new ArrayList<>(productos.values());  
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public void realizarOperacion(String nombre, int cantidad){
        lock.lock();
        try{
            Producto producto = productos.get(nombre);
            if (producto != null){
                producto.actualizarCantidad(cantidad);
                
            }    
        }finally{
            lock.unlock();
        }
    }
    
    
}
