package Servicio;

import DAO.IUsuarioDAO;

public class UsuarioServicio {

    private final IUsuarioDAO usuarioDAO;

    public UsuarioServicio(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean validarUsuario(String usuario, String password) throws Exception {
        return usuarioDAO.validar(usuario, password);
    }
}
