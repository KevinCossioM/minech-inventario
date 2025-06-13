package Servicio;

import DAO.IProductoDAO;
import Modelo.Producto;
import java.util.List;

public class AlertaServicio {

    private final IProductoDAO productoDAO;

    public AlertaServicio(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<Producto> obtenerProductosBajoStock(int limite) {
        return productoDAO.obtenerProductosBajoStock(limite);
    }
}
