package Servicio;

import DAO.IProductoDAO;
import Modelo.Producto;

public class ProductoServicio {
    private final IProductoDAO productoDAO;

    public ProductoServicio(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public boolean registrarProducto(String nombre, String categoria, String codigo, String proveedor, String precioStr, String stockStr) throws Exception {
        double precio = Double.parseDouble(precioStr);
        int stock = Integer.parseInt(stockStr);

        if (nombre.isEmpty() || categoria.isEmpty() || codigo.isEmpty() || proveedor.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        Producto producto = new Producto(nombre, categoria, codigo, proveedor, precio, stock);
        return productoDAO.registrar(producto);
    }
}
