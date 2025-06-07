package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public boolean validar(String usuario, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        boolean valido = false;

        try {
            con = Conexion.conectar();  // Obtienes la conexión desde la clase Conexion
            if (con == null) {
                System.out.println("No se pudo establecer la conexión");
                return false;
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                valido = true;
            }
        } catch (Exception e) {
            System.out.println("Error en validar usuario: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error cerrando conexiones: " + e);
            }
        }
        return valido;
    }
}
