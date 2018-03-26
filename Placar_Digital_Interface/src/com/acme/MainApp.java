/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import com.acme.model.playSound;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 *
 * @author Mateus PDK
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent fxmlCena = FXMLLoader.load(this.getClass().getResource("/com/acme/view/WaitScreen.fxml"));
        Scene cena = new Scene(fxmlCena);
        primaryStage.setScene(cena);
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        playSound p = new playSound();
        p.playsound("src/com/acme/resources/audio/intermission.wav");
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
