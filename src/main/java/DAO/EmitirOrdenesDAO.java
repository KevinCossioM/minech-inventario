package DAO;

import Modelo.EmitirOrdenesModelo;
import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmitirOrdenesDAO {

    public boolean registrarOrden(EmitirOrdenesModelo orden) throws Exception {
        String sql = "INSERT INTO ordenes (numero_orden, fecha, producto, cantidad, precio, proveedor, observacion) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, orden.getNumeroOrden());
            ps.setString(2, orden.getFecha());
            ps.setString(3, orden.getProducto());
            ps.setInt(4, orden.getCantidad());
            ps.setDouble(5, orden.getPrecio());
            ps.setString(6, orden.getProveedor());
            ps.setString(7, orden.getObservacion());

            return ps.executeUpdate() > 0;
        }
    }
}
