
package Controlador;
import DAO.UsuarioDAO;
public class Ctrl_Usuario {
    private UsuarioDAO usuarioDAO;

    public Ctrl_Usuario() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean validarUsuario(String usuario, String password) {
        return usuarioDAO.validar(usuario, password);
    }
    
}
