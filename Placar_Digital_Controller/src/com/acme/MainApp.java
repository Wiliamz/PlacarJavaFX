/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Mateus PDK
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent fxmlCena = FXMLLoader.load(this.getClass().getResource("/com/acme/view/PlacarBasquete.fxml"));
        StackPane root = new StackPane();
        Rectangle2D r = Screen.getPrimary().getBounds();
        Scene cena = new Scene(fxmlCena, r.getWidth(), r.getHeight());

        System.out.println("x: "+r.getWidth()+" y: "+r.getHeight());

        Rectangle rect = new Rectangle(r.getWidth(), r.getHeight());
        root.getChildren().add(rect);

        // scene.setCursor(Cursor.NONE);  // Uncomment, if you don't need a cursor
        primaryStage.setScene(cena);
        primaryStage.setFullScreen(true);
        primaryStage.show();
//        Parent fxmlCena = FXMLLoader.load(this.getClass().getResource("/com/acme/view/Placar.fxml"));
//        Scene cena = new Scene(fxmlCena);
//        primaryStage.setScene(cena);
//        primaryStage.setResizable(false);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.setFullScreen(true);
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
