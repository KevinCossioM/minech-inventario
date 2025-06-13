package DAO;
import Modelo.Producto;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductoDAO implements IProductoDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProductoDAO.class);
    @Override
    public boolean registrar(Producto producto) throws Exception {
        String sql = "INSERT INTO productos (nombre, categoria, codigo, proveedor, precio_unitario, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setString(3, producto.getCodigo());
            ps.setString(4, producto.getProveedor());
            ps.setDouble(5, producto.getPrecioUnitario());
            ps.setInt(6, producto.getStock());

            boolean result = ps.executeUpdate() > 0;
            if (result) {
                logger.info("Producto registrado: {}", producto.getNombre());
            }
            return result;
        } catch (Exception e) {
            logger.error("Error al registrar producto", e);
            throw e;
        }
    }

    @Override
    public List<Producto> obtenerProductosBajoStock(int limite) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT nombre, categoria, codigo, proveedor, precio_unitario, stock FROM productos WHERE stock < ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, limite);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setCodigo(rs.getString("codigo"));
                p.setProveedor(rs.getString("proveedor"));
                p.setPrecioUnitario(rs.getDouble("precio_unitario"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
