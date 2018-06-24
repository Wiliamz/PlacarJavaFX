/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import com.acme.commons.Server;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel Cardoso
 */
public class MainApp extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Server s = new Server();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
