/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.commons.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel Cardoso
 */
public class JuizFutebolController extends Application implements Observer {

//    private Client client;
    
    @FXML
    private Label lblGolsA;
    @FXML
    private Label lblTempoDecorrido;
    @FXML
    private Label lblGolsB;
    @FXML
    private Label lblProrrogacao;
    @FXML
    private JFXButton btnPausarPartida;
    @FXML
    private JFXTextField tfAddProrrogacao;
    @FXML
    private JFXButton btnAddProrrogacao;
    @FXML
    private JFXButton btnEndGame;
    @FXML
    private JFXButton btnAddGolA;
    @FXML
    private JFXButton btnRemoveGolA;
    @FXML
    private JFXButton btnAddFaltaA;
    @FXML
    private JFXButton btnRemoveFaltaA;
    @FXML
    private JFXButton btnKickPlayerA;
    @FXML
    private Label labelJogadoresA;
    @FXML
    private JFXButton btnAddGolB;
    @FXML
    private JFXButton btnRemoveGolB;
    @FXML
    private JFXButton btnAddFaltaB;
    @FXML
    private JFXButton btnRemoveFaltaB;
    @FXML
    private JFXButton btnKickPlayerB;
    @FXML
    private Label labelJogadoresB;
  

    @FXML
    private void handlerPauseGame(ActionEvent event) {
        System.out.println("PÃO DE BATATA");
        Client.maisPonto();
    }

    @FXML
    private void handlerAddProrrogacao(ActionEvent event) {
    }

    @FXML
    private void handlerEndGame(ActionEvent event) {
    }

    @FXML
    private void handlerAddGolA(ActionEvent event) {
    }

    @FXML
    private void handlerRemoveGolA(ActionEvent event) {
    }

    @FXML
    private void handlerAddFaltaA(ActionEvent event) {
    }

    @FXML
    private void handlerRemoveFaltaA(ActionEvent event) {
    }

    @FXML
    private void handlerKickA(ActionEvent event) {
    }

    @FXML
    private void handlerAddGolB(ActionEvent event) {
    }

    @FXML
    private void handlerRemoveGolB(ActionEvent event) {
    }

    @FXML
    private void handlerAddFaltaB(ActionEvent event) {
    }

    @FXML
    private void handlerRemoveFaltaB(ActionEvent event) {
    }

    @FXML
    private void handlerKickB(ActionEvent event) {
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ATUALIZOU CARAI");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Client.getJogo().addObserver(this);
    }
    
}
