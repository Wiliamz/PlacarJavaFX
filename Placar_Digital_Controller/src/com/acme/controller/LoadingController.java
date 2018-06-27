/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.commons.Client;
import com.acme.commons.Observer;
import com.acme.enums.TipoUsuario;
import com.acme.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel Cardoso
 */
public class LoadingController extends Observer {

    static Usuario usuario;
    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public LoadingController(Usuario u, Stage stage) {
        this.usuario = u;
        this.stage = stage;
        Client.getJogo().attach(this);
    }

    @Override
    public void update() {
        Observer obs = this;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (Client.getJogo().isJogando()) {
                    FXMLLoader fxmlLoader = null;
                    if (LoadingController.usuario.getTipo().equals(TipoUsuario.ADMIN)) {
                        if (Client.getJogo().getTipoJogo().equalsIgnoreCase("Basquete")) {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/JuizBasquete.fxml"));
                        } else {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/JuizFutebol.fxml"));
                        }
                    } else if (LoadingController.usuario.getTipo().equals(TipoUsuario.MARKETING)) {
                        fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Marketing.fxml"));
                    } else if (LoadingController.usuario.getTipo().equals(TipoUsuario.JUIZ)) {
                        if (Client.getJogo().getTipoJogo().equalsIgnoreCase("Basquete")) {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/JuizBasquete.fxml"));
                        } else {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/JuizFutebol.fxml"));
                        }
                    } else if (LoadingController.usuario.getTipo().equals(TipoUsuario.COMUM)) {
                        if (Client.getJogo().getTipoJogo().equalsIgnoreCase("Basquete")) {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/PlacarBasquete.fxml"));
                        } else {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/PlacarFutebol.fxml"));
                        }
                    }
                    Parent root1 = null;
                    try {
                        root1 = (Parent) fxmlLoader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Stage stage = new Stage();
                    stage.setTitle("Placar Eletronico");
                    stage.setScene(new Scene(root1));
                    stage.show();
                    Client.getJogo().removeObserver(obs);
                    LoadingController.stage.close();
                }
            }
        });
    }

}
