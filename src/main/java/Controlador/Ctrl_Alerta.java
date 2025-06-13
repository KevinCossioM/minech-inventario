package controlador;

import Modelo.Producto;
import Servicio.AlertaServicio;
import java.util.List;

public class Ctrl_Alerta {

    private final AlertaServicio alertaServicio;

    public Ctrl_Alerta(AlertaServicio alertaServicio) {
        this.alertaServicio = alertaServicio;
    }

    public List<Producto> obtenerProductosConStockBajo(int limite) {
        return alertaServicio.obtenerProductosBajoStock(limite);
    }
}
