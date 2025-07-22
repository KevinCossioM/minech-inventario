package Servicio;

import DAO.IProductoDAO;
import Modelo.Producto;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

public class ProductoServicio {

    private final IProductoDAO productoDAO;

    public ProductoServicio(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public boolean registrarProducto(String nombre, String categoria, String codigo, String proveedor, String precioStr, String stockStr) throws Exception {
        if (Strings.isNullOrEmpty(precioStr) || Strings.isNullOrEmpty(stockStr)) {
            throw new IllegalArgumentException("Precio y stock son obligatorios.");
        }

        if (StringUtils.isBlank(nombre) || StringUtils.isBlank(categoria) || StringUtils.isBlank(codigo) || StringUtils.isBlank(proveedor)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        double precio = Double.parseDouble(precioStr);
        int stock = Integer.parseInt(stockStr);

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
