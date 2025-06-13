package Servicio;

import DAO.EmitirOrdenesDAO;
import Modelo.EmitirOrdenesModelo;

public class EmitirOrdenesServicio {

    private final EmitirOrdenesDAO dao;

    public EmitirOrdenesServicio(EmitirOrdenesDAO dao) {
        this.dao = dao;
    }

    public boolean registrarOrden(EmitirOrdenesModelo orden) throws Exception {
        return dao.registrarOrden(orden);
    }
}
