
package Servicio;
import DAO.UsuarioDAO;

public class UsuarioServicio {
    private UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean validarUsuario(String usuario, String password) {
        if (usuario == null || usuario.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Usuario o contraseña vacíos");
            return false;
        }

        // Aquí puedes agregar más validaciones si quieres

        // Llama al DAO para validar
        return usuarioDAO.validar(usuario, password);
    }
}