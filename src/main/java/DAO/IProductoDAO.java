package DAO;

import Modelo.Producto;
import java.util.List;

public interface IProductoDAO {
    boolean registrar(Producto producto) throws Exception;
    
    List<Producto> obtenerProductosBajoStock(int limite);
}
