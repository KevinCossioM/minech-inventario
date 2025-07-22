package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
public static Connection conectar() {
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/minech?useSSL=false&serverTimezone=UTC",
            "root", ""
        );
        System.out.println("Conexión exitosa");
    } catch (ClassNotFoundException e) {
        System.out.println("Error al cargar el driver: " + e.getMessage());
    } catch (SQLException e) {
        System.out.println("Error en la conexión local: " + e.getMessage());
    }
    return con;
}

}
