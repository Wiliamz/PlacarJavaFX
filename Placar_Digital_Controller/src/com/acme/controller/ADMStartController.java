/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.MainApp;
import com.acme.model.TimeJogo;
import com.acme.model.TimeJogoWrapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * FXML Controller class
 *
 * @author wiliam
 */
public class ADMStartController implements Initializable {

    @FXML
    private JFXButton JfxBEditTimes;
    @FXML
    private JFXTextField JfxTfTempo;
    @FXML
    private JFXComboBox<TimeJogo> JfxCbTimeA;
    @FXML
    private JFXButton JfxBEscalarTimes;
    @FXML
    private JFXButton JfxBStartGame;
    @FXML
    private JFXRadioButton jfxrbBasquete;
    @FXML
    private JFXRadioButton jfxrbFutebol;

    TimeJogoWrapper tw;
    @FXML
    private JFXComboBox<TimeJogo> JfxCbTimeB;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleEscalarTimeAction(ActionEvent event
    ) {
        try {
            FXMLLoader fxmlLoader = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Times.fxml"));
            Parent root1;

            root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Escalador de Times");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ADMStartController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleEditTimeAction(ActionEvent event
    ) {
        try {
            FXMLLoader fxmlLoader = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Times.fxml"));
            Parent root1;

            root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Escalador de Times");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ADMStartController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handlejfxrbBasqueteAction(ActionEvent event
    ) {
        jfxrbFutebol.setSelected(false);
    }

    @FXML
    private void handlejfxrbFutebolAction(ActionEvent event
    ) {
        jfxrbBasquete.setSelected(false);
    }
}
