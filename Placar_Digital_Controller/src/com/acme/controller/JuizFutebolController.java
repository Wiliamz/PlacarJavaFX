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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Gabriel Cardoso
 */
public class JuizFutebolController extends com.acme.commons.Observer {

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
    private Label labelJogadoresA;
    @FXML
    private JFXButton btnAddGolB;
    @FXML
    private JFXButton btnRemoveGolB;
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
        Client.addProrrogacao(tfAddProrrogacao.getText().replace(":", "-"));
    }

    @FXML
    private void handlerEndGame(ActionEvent event) {
        Client.endGame();
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

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public JuizFutebolController() {
        Client.getJogo().attach(this);
    }

    public void atualizarTela() {
        Platform.runLater(() -> {
            lblGolsA.setText(String.valueOf(Client.getJogo().getPontosA()));
            lblGolsB.setText(String.valueOf(Client.getJogo().getPontosB()));
            lblProrrogacao.setText(Utils.formatSecondsToSTring(Client.getJogo().getTempoProrrogacacao()));
            lblTempoDecorrido.setText(Utils.formatSecondsToSTring(Client.getJogo().getTempoDecorrido()));
            verificarFinal();
        });
    }

    public void verificarFinal() {
        if (Client.getJogo().isTerminada()) {
            String msg = "";
            if (Client.getJogo().getPontosA() == Client.getJogo().getPontosB()) {
                msg = "Empatou !!! ";
            } else if (Client.getJogo().getPontosA() > Client.getJogo().getPontosB()) {
                msg = "O time " + Client.getJogo().getTimeA() + " foi o ganhador!!";
            } else if (Client.getJogo().getPontosA() < Client.getJogo().getPontosB()) {
                msg = "O time " + Client.getJogo().getTimeB() + " foi o ganhador!!";
            }
            JOptionPane.showMessageDialog(null, msg);
            System.exit(0);
        }
    }

    @Override
    public void update() {
        atualizarTela();
    }

}
