package DAO;

import Modelo.Producto;
import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoDAO implements IProductoDAO {

    @Override
    public boolean registrar(Producto producto) throws Exception {
        String sql = "INSERT INTO productos (nombre, categoria, codigo, proveedor, precio_unitario, stock) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setString(3, producto.getCodigo());
            ps.setString(4, producto.getProveedor());
            ps.setDouble(5, producto.getPrecioUnitario());
            ps.setInt(6, producto.getStock());

            return ps.executeUpdate() > 0;
        }
    }
}
