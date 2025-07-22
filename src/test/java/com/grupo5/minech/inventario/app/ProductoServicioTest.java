package com.grupo5.minech.inventario.app;

import DAO.IProductoDAO;
import Modelo.Producto;
import Servicio.ProductoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoServicioTest {

    private IProductoDAO mockDAO;
    private ProductoServicio servicio;

    @BeforeEach
    void setUp() {
        mockDAO = mock(IProductoDAO.class);
        servicio = new ProductoServicio(mockDAO);
    }

    @Test
    void testRegistrarProducto_Exitoso() throws Exception {
        when(mockDAO.registrar(any(Producto.class))).thenReturn(true);

        boolean resultado = servicio.registrarProducto("Mouse", "Electrónica", "P001", "Logitech", "25.0", "10");

        assertTrue(resultado);
        verify(mockDAO, times(1)).registrar(any(Producto.class));
    }

    @Test
    void testRegistrarProducto_PrecioNegativo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            servicio.registrarProducto("Mouse", "Electrónica", "P001", "Logitech", "-5", "10");
        });
        assertEquals("El precio debe ser mayor a 0.", ex.getMessage());
    }

    @Test
    void testRegistrarProducto_StockNegativo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            servicio.registrarProducto("Mouse", "Electrónica", "P001", "Logitech", "25.0", "-3");
        });
        assertEquals("El stock no puede ser negativo.", ex.getMessage());
    }

    @Test
    void testRegistrarProducto_CamposVacios() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            servicio.registrarProducto("", "", "", "", "25.0", "10");
        });
        assertEquals("Todos los campos son obligatorios.", ex.getMessage());
    }

    @Test
    void testRegistrarProducto_PrecioOVacio() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            servicio.registrarProducto("Mouse", "Electrónica", "P001", "Logitech", "", "10");
        });
        assertEquals("Precio y stock son obligatorios.", ex.getMessage());
    }
}
