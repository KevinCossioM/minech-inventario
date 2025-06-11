package DAO;

import Modelo.Producto;

public interface IProductoDAO {
    boolean registrar(Producto producto) throws Exception;
}
