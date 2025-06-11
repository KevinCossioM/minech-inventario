package controlador;

import Servicio.ProductoServicio;

public class Ctrl_Producto {

    private final ProductoServicio productoServicio;

    public Ctrl_Producto(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public boolean guardarProducto(String nombre, String categoria, String codigo, String proveedor, String precio, String stock) {
        try {
            return productoServicio.registrarProducto(nombre, categoria, codigo, proveedor, precio, stock);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
