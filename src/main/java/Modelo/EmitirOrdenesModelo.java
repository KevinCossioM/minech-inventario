/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class EmitirOrdenesModelo {

    private String numeroOrden;
    private String fecha;
    private String producto;
    private int cantidad;
    private double precio;
    private String proveedor;
    private String observacion;

    public EmitirOrdenesModelo(String numeroOrden, String fecha, String producto, int cantidad, double precio, String proveedor, String observacion) {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
        this.observacion = observacion;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getObservacion() {
        return observacion;
    }
}
