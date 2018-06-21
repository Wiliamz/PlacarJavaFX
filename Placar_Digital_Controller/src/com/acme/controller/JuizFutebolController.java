/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Gabriel Cardoso
 */
public class JuizFutebolController {

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
    
}
