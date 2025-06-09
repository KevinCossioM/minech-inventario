package Controlador;

import Servicio.UsuarioServicio;

public class Ctrl_Usuario {
    private UsuarioServicio usuarioServicio;

    public Ctrl_Usuario() {
        this.usuarioServicio = new UsuarioServicio();
    }

    public boolean validarUsuario(String usuario, String password) {
        return usuarioServicio.validarUsuario(usuario, password);
    }
}
