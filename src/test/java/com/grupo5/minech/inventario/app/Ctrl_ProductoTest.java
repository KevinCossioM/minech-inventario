package com.grupo5.minech.inventario.app;

import Modelo.Producto;
import Servicio.ProductoServicio;
import controlador.Ctrl_Producto;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ctrl_ProductoTest {

    private ProductoServicio mockServicio;
    private Ctrl_Producto ctrlProducto;

    @BeforeEach
    public void setup() {
        mockServicio = mock(ProductoServicio.class);
        ctrlProducto = new Ctrl_Producto(mockServicio);
    }

    @Test
    public void testGuardarProducto_Exitoso() {
        // Arrange
        Producto producto = new Producto("Mouse", "Electrónica", "P001", "Logitech", 25.0, 10);
        try {
            when(mockServicio.registrarProducto(
                    anyString(), anyString(), anyString(), anyString(), anyString(), anyString()
            )).thenReturn(true);
        } catch (Exception ex) {
            Logger.getLogger(Ctrl_ProductoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Act
        boolean resultado = ctrlProducto.guardarProducto(producto);

        // Assert
        assertTrue(resultado);
        try {
            verify(mockServicio, times(1)).registrarProducto(
                    eq("Mouse"), eq("Electrónica"), eq("P001"), eq("Logitech"), eq("25.0"), eq("10")
            );
        } catch (Exception ex) {
            Logger.getLogger(Ctrl_ProductoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGuardarProducto_Fallo() {
        Producto producto = new Producto("Teclado", "Electrónica", "P002", "Genius", 30.0, 5);
        try {
            when(mockServicio.registrarProducto(any(), any(), any(), any(), any(), any())).thenThrow(new RuntimeException());
        } catch (Exception ex) {
            Logger.getLogger(Ctrl_ProductoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean resultado = ctrlProducto.guardarProducto(producto);

        assertFalse(resultado);
    }
}
