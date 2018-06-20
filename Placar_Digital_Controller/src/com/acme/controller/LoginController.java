/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.MainApp;
import com.acme.commons.Client;
import com.acme.commons.Server;
import com.acme.commons.TipoUsuario;
import com.acme.commons.Utils;
import com.acme.model.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Cardoso
 */
public class LoginController {

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXTextField txtIp;

    @FXML
    private JFXTextField login;

    @FXML
    private JFXTextField senha;

    @FXML
    void bExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnSignInAction(ActionEvent event) {
        System.out.println("IPPPPP" + txtIp.getText());
//        System.out.println("OI" + login.getText());
//Utils.fazerLogin(login.getText(), senha.getText());
//        Task task = new Task<Void>() {
//            @Override
//            public Void call() {
////                System.out.println("LOGIN"+login.getText());
////                   Utils.fazerLogin(login.getText(), senha.getText());
////                try {
////                    Client.rodar(txtIp.getText());
//
////                    Client.rodar("169.254.209.118");
//                // do stuff
////                } catch (IOException ex) {
////                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
////                }
//                return null;
//            }
//        };
//        new Thread(task).start();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Client.rodar(txtIp.getText());
//                        } catch (ClassNotFoundException ex) {
//                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (UnknownHostException ex) {
//                            System.out.println("meu zeus deu merda");
//                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                });
                Task task = new Task<Void>() {
                    @Override
                    public Void call() {
                        try {
                            Client.rodar(txtIp.getText());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnknownHostException ex) {
                            System.out.println("meu zeus deu merda");
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return null;
                    }
                };
                new Thread(task).start();
//                try {
//                    Client.rodar(txtIp.getText());
//System.out.println("LOGIN"+login.getText());
                if (!login.getText().isEmpty() && !senha.getText().isEmpty()) {
                    try {
                        Usuario u = Utils.fazerLogin(login.getText(), Utils.gerarMd5(senha.getText()));
                        if (u != null) {

                            FXMLLoader fxmlLoader = null;
                            if (u.getTipo().equals(TipoUsuario.ADMIN)) {
                                fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/ADMStart.fxml"));
                            } else if (u.getTipo().equals(TipoUsuario.MARKETING)) {
                                fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Marketing.fxml"));
                            } else if (u.getTipo().equals(TipoUsuario.JUIZ)) {
                                fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Juiz.fxml"));
                            }
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setTitle("Placar Eletronico");
                            stage.setScene(new Scene(root1));
                            stage.show();
                            MainApp.stage.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "Errou feio, errou rude!");
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Placar.fxml"));

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
                    MainApp.stage.close();
                }
            }
        });
    }

}
