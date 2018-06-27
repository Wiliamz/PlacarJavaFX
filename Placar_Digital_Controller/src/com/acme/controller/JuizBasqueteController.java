/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.commons.Client;
import com.acme.commons.Observer;
import com.acme.commons.Utils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel Cardoso
 */
public class JuizBasqueteController extends Observer implements Initializable {

    @FXML
    private Label lblGolsA;
    @FXML
    private Label lblTempoDecorrido;
    @FXML
    private Label lblTempoBola;
    @FXML
    private Label lblGolsB;
    @FXML
    private Label lblProrrogacao;
    @FXML
    private JFXButton btnAddUmB;
    @FXML
    private JFXButton btnAddDoisB;
    @FXML
    private JFXButton btnAddTresB;
    @FXML
    private JFXButton btnAddUmA;
    @FXML
    private JFXButton btnAddDoisA;
    @FXML
    private JFXButton btnAddTresA;
    @FXML
    private JFXButton btnRemoverGolA;
    @FXML
    private JFXTextField tfAddProrrogacao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

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
    private void handlerZerarTempoBola(ActionEvent event) {
        Client.getJogo().setTempoBola(0);
    }

    @FXML
    private void handleAddUmB(ActionEvent event) {
        Client.addPontoB(1);
    }

    @FXML
    private void handleAddDoisB(ActionEvent event) {
        Client.addPontoB(2);
    }

    @FXML
    private void handleAddTresB(ActionEvent event) {
        Client.addPontoB(3);
    }

    @FXML
    private void handleRemoverGolB(ActionEvent event) {
        Client.removerPontoB();
    }

    @FXML
    private void handleAddUmA(ActionEvent event) {
        Client.addPontoA(1);
    }

    @FXML
    private void handleAddDoisA(ActionEvent event) {
        Client.addPontoA(2);
    }

    @FXML
    private void handleAddTresA(ActionEvent event) {
        Client.addPontoA(3);
    }

    @FXML
    private void handleRemoverGolA(ActionEvent event) {
        Client.removerPontoA();
    }

    @FXML
    private void handlerEndGame(ActionEvent event) {
        Client.endGame();
    }

    private void handlerAddGolA(ActionEvent event) {
        Client.addPontoA();
    }

    private void handlerAddGolB(ActionEvent event) {
        Client.addPontoB();
    }

    public JuizBasqueteController() {
        Client.getJogo().attach(this);
    }

    @Override
    public void update() {
        atualizarTela();
    }

    public void atualizarTela() {
        Platform.runLater(() -> {
            lblGolsA.setText(String.valueOf(Client.getJogo().getPontosA()));
            lblGolsB.setText(String.valueOf(Client.getJogo().getPontosB()));
            lblProrrogacao.setText(Utils.formatSecondsToSTring(Client.getJogo().getTempoProrrogacacao()));
            lblTempoDecorrido.setText(Utils.formatSecondsToSTring(Client.getJogo().getTempoEstimado() - Client.getJogo().getTempoDecorrido()));
            lblTempoBola.setText(Utils.formatSecondsToSTring(Client.getJogo().getTempoBola()));
            Utils.verificarFinal();
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
