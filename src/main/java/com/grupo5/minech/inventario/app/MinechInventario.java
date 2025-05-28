/* Licencia
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/* @author GRUPO5 */

package com.grupo5.minech.inventario.app;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MinechInventario extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("¡Minechi Inventario funciona!");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Minechi - Inventario");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}