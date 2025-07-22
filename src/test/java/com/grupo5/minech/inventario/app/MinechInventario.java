package com.grupo5.minech.inventario.app;

import Vistas.Login;
//import Vistas.MenuPrincipal;

public class MinechInventario {
    public static void main(String[] args) {
        // Ejecuta el login en el hilo de eventos de Swing para evitar problemas de concurrencia
        javax.swing.SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);  // Mostrar la ventana de login
            
        });
//        javax.swing.SwingUtilities.invokeLater(() -> {
//            MenuPrincipal menuPrincipal = new MenuPrincipal();
//            menuPrincipal.setVisible(true);  // Mostrar la ventana de lmenu
//        });
//        
    }
}
