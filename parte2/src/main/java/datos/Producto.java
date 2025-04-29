package datos;

public class Producto {
    private String nombre;
    private int cantidad;
    
    public Producto(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public synchronized int getCantidad(){
        return cantidad;
    }
    
    public synchronized void actualizarCantidad(int cantidad){
        this.cantidad += cantidad;
    }
}
