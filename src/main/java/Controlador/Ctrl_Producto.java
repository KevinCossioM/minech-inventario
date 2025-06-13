package controlador;

import Modelo.Producto;
import Servicio.ProductoServicio;
/**
 *
 * @author Brian Rivera
 */
public class Ctrl_Producto {

    private final ProductoServicio productoServicio;

    public Ctrl_Producto(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

public boolean guardarProducto(Producto producto) {
    try {
        return productoServicio.registrarProducto(
            producto.getNombre(),
            producto.getCategoria(),
            producto.getCodigo(),
            producto.getProveedor(),
            String.valueOf(producto.getPrecioUnitario()),
            String.valueOf(producto.getStock())
        );
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}
