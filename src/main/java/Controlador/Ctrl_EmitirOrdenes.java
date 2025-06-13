package Controlador;

import Modelo.EmitirOrdenesModelo;
import Servicio.EmitirOrdenesServicio;

public class Ctrl_EmitirOrdenes {

    private final EmitirOrdenesServicio servicio;

    // Constructor que recibe el servicio (inyección de dependencias)
    public Ctrl_EmitirOrdenes(EmitirOrdenesServicio servicio) {
        this.servicio = servicio;
    }

    // Método para registrar una orden
    public boolean registrarOrden(EmitirOrdenesModelo orden) {
        try {
            return servicio.registrarOrden(orden);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
