package controlador;

import Servicio.UsuarioServicio;

public class Ctrl_Usuario {

    private final UsuarioServicio usuarioServicio;

    // Recibe el servicio ya creado (inyección de dependencias)
    public Ctrl_Usuario(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    public boolean validarUsuario(String usuario, String password) {
        try {
            return usuarioServicio.validarUsuario(usuario, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
