package Servicio;

import DAO.IUsuarioDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
public class UsuarioServicio {

    private final IUsuarioDAO usuarioDAO;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServicio.class);

    public UsuarioServicio(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean validarUsuario(String usuario, String password) throws Exception {
        if (StringUtils.isBlank(usuario) || StringUtils.isBlank(password)) {
            logger.warn("Intento de validación con campos vacíos");
            throw new IllegalArgumentException("Usuario y contraseña son obligatorios.");
        }

        boolean esValido = usuarioDAO.validar(usuario, password);
        if (esValido) {
            logger.info("Inicio de sesión exitoso para el usuario: {}", usuario);
        } else {
            logger.warn("Inicio de sesión fallido para el usuario: {}", usuario);
        }

        return esValido;
    }
}
