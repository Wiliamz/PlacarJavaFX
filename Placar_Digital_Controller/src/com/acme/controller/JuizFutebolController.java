/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.commons.Client;
import com.acme.commons.Utils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel Cardoso
 */
public class JuizFutebolController extends com.acme.commons.Observer {

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
        if (Client.getJogo().isPausado()) {
//            Image image = new Image(getClass().getResourceAsStream("../resources/icons/play.png"));
//            btnPausarPartida.setGraphic(new ImageView(image));
            Client.continuarJogo();
        } else {
//            Image image = new Image(getClass().getResourceAsStream("../resources/icons/pause.png"));
//            btnPausarPartida.setGraphic(new ImageView(image));
            Client.pausarJogo();
        }
    }

    @FXML
    private void handlerAddProrrogacao(ActionEvent event) {
    }

    @FXML
    private void handlerEndGame(ActionEvent event) {
    }

    @FXML
    private void handlerAddGolA(ActionEvent event) {
        Client.addPontoA();
    }

    @FXML
    private void handlerAddGolB(ActionEvent event) {
        Client.addPontoB();
    }

    @FXML
    private void handlerRemoveGolA(ActionEvent event) {
        Client.removerPontoA();
    }
    
    @FXML
    private void handlerRemoveGolB(ActionEvent event) {
        Client.removerPontoB();
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
    private void handlerAddFaltaB(ActionEvent event) {
    }

    @FXML
    private void handlerRemoveFaltaB(ActionEvent event) {
    }

    @FXML
    private void handlerKickB(ActionEvent event) {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public JuizFutebolController() {
        Client.getJogo().attach(this);
//        if (Client.getJogo().isPausado()) {
//            Image image = new Image(getClass().getResourceAsStream("../resources/icons/play.png"));
//            btnPausarPartida.setGraphic(new ImageView(image));
//            Client.continuarJogo();
//        } else {
//            Image image = new Image(getClass().getResourceAsStream("../resources/icons/pause.png"));
//            btnPausarPartida.setGraphic(new ImageView(image));
//            Client.pausarJogo();
//        }
    }

    public void atualizarTela() {
        Platform.runLater(() -> {
            lblGolsA.setText(String.valueOf(Client.getJogo().getPontosA()));
            lblGolsB.setText(String.valueOf(Client.getJogo().getPontosB()));
            lblTempoDecorrido.setText(Utils.formatSecondsToSTring(Client.getJogo().getTempoDecorrido()));
        });
    }

    @Override
    public void update() {
        atualizarTela();
    }

}
