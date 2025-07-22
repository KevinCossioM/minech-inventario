package Modelo;

public class Producto {
    private String nombre;
    private String categoria;
    private String codigo;
    private String proveedor;
    private double precioUnitario;
    private int stock;

    public Producto() {}

    public Producto(String nombre, String categoria, String codigo, String proveedor, double precioUnitario, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
