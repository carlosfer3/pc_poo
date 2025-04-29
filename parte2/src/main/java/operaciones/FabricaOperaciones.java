package operaciones;

import datos.Inventario;

public class FabricaOperaciones {
    public static OperacionInventario crearOperacion(String tipo, String producto, int cantidad , Inventario destino){
        switch(tipo){
            case "ajuste":
                return new AjusteInventario(producto, cantidad);
            case "transferencia":
                return new TransferenciaInventario(producto, cantidad,destino);
            case "agregar":
                return new AgregarInventario(producto, cantidad);
            default:
                throw new IllegalArgumentException("Operacion no disponible");
        }
    }
    
    public static String crearOperacionMostrarInventario(Inventario inventario) {
        return MostrarInventario.obtenerInventario(inventario);
    }
    
    public static String obtenerHistorial(HistorialOperaciones historialOperaciones) {
        return String.join("\n", historialOperaciones.obtenerHistorial());
    }
}
