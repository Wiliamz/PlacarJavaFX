/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.model.Jogador;
import com.acme.model.JogadoresWrapper;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * FXML Controller class
 *
 * @author wilia
 */
public class JogadoresController implements Initializable {

    @FXML
    private JFXButton jfxbtnAddJogador;
    @FXML
    private JFXButton jfxbtnCancel;
    @FXML
    private JFXComboBox<TimeJogo> jfxcbTimes;
    @FXML
    private JFXTextField jfxtfJogador;

    Jogador player = new Jogador();
    JogadoresWrapper pw = new JogadoresWrapper();
    TimeJogoWrapper tw = new TimeJogoWrapper();
    String nome = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(
                () -> {
                    try {
                        File arqxml = new File("src/com/acme/xml/times.xml");
                        jfxcbTimes.getItems().clear();
                        JAXBContext context = JAXBContext.newInstance(TimeJogoWrapper.class);
                        Unmarshaller unm = context.createUnmarshaller();
                        TimeJogoWrapper time = (TimeJogoWrapper) unm.unmarshal(arqxml);
                        jfxcbTimes.setItems(FXCollections.observableArrayList(time.getTimes()));
                        jfxcbTimes.setConverter(new StringConverter<TimeJogo>() {
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
                }
        );

    }

    @FXML
    private void handlejfxbtnAddJogadorAction(ActionEvent event) {

        
        
        try {
            nome = jfxtfJogador.getText();
            System.out.println(nome);
            player.setNome(nome);
            player.setTime(jfxcbTimes.getSelectionModel().getSelectedItem());
            pw.getJogadores().add(player);
            player = new Jogador();
            
            try {
                File file = new File("src/com/acme/xml/times.xml");
                JAXBContext jaxbContextTimes = JAXBContext.newInstance(TimeJogoWrapper.class);
                Marshaller jaxbMarshallerT = jaxbContextTimes.createMarshaller();
                jaxbMarshallerT.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshallerT.marshal(tw, file);
            } catch (JAXBException ex) {
                Logger.getLogger(TimesHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                File file = new File("src/com/acme/xml/jogadores.xml");
                JAXBContext jaxbContextJogadores = JAXBContext.newInstance(JogadoresWrapper.class);
                Marshaller jaxbMarshallerJ = jaxbContextJogadores.createMarshaller();
                jaxbMarshallerJ.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshallerJ.marshal(pw, file);
                 
            } catch (JAXBException ex) {
                Logger.getLogger(TimesHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!!!");

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Falta alguma coisa!!", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    private void handlejfxbtnCancelAction(ActionEvent event) {

    }

    @FXML
    private void handlejfxcbTimesAction(MouseEvent event) {
    }

}
