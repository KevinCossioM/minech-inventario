package DAO;

public interface IUsuarioDAO {
    boolean validar(String usuario, String password) throws Exception;
}

