/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.model.TimeJogo;
import com.acme.model.TimeJogoWrapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private JFXComboBox<TimeJogo> JfxCbTimeB;
    @FXML
    private JFXButton JfxBEscalarTimes;
    @FXML
    private JFXButton JfxBStartGame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleEscalarTimeAction(ActionEvent event) {

        Platform.runLater(() -> {
            try {
                
                File arqxml = new File("src/com/acme/xml/times.xml");
                JfxCbTimeA.getItems().clear();
                JAXBContext context = JAXBContext.newInstance(TimeJogoWrapper.class);
                Unmarshaller unm = context.createUnmarshaller();
                TimeJogoWrapper time = (TimeJogoWrapper) unm.unmarshal(arqxml);
                JfxCbTimeA.setItems(FXCollections.observableArrayList(time.getTimes()));
                JfxCbTimeA.setConverter(new StringConverter<TimeJogo>() {
                    @Override
                    public String toString(TimeJogo object) {
                        return object.getNome();
                    }

                    @Override
                    public TimeJogo fromString(String string) {
                        return null;
                    }
                });
                
            } catch (JAXBException ex) {
                Logger.getLogger(ADMStartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }

    @FXML
    private void handleEditTimeAction(ActionEvent event) {
    }

}
