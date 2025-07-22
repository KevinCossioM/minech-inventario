package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public boolean validar(String usuario, String password) throws Exception {
        String sql = "SELECT password FROM usuarios WHERE usuario = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String passwordDB = rs.getString("password");
                // Aquí compara la contraseña plano a plano
                // Para producción, usa hashing y salt
                return password.equals(passwordDB);
            } else {
                return false;
            }
        }
    }
}