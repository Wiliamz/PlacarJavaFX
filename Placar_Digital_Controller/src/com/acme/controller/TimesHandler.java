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
import com.jfoenix.controls.JFXDialog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author wiliam
 */
public class TimesHandler {

    @FXML
    private JFXButton jfxbtnAddTeam;
    @FXML
    private JFXButton jfxbtnDeleteJogador;
    @FXML
    private JFXButton jfxbtnMoveJogador;
    @FXML
    private JFXButton jfxbtnAddJogador;
    @FXML
    private JFXButton jfxbtnDeleteJogador2;
    @FXML
    private JFXComboBox<TimeJogo> jfxcbSelectTime;

    TimeJogo t = new TimeJogo();
    TimeJogoWrapper tw = new TimeJogoWrapper();
    ArrayList<TimeJogo> times = new ArrayList();
    String nome;

    @FXML
    private void handlejfxbtnAddTeamAction(ActionEvent event) throws PropertyException {

        //Fazer método que confere se o Time já não existe!
        try {
            File file = new File("src/com/acme/xml/times.xml");
            JAXBContext context = JAXBContext.newInstance(TimeJogoWrapper.class);
            Unmarshaller unm = context.createUnmarshaller();
            tw = (TimeJogoWrapper) unm.unmarshal(file);
            times = tw.getTimes();
        } catch (JAXBException ex) {
            Logger.getLogger(TimesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        nome = JOptionPane.showInputDialog("Digite o nome do seu time");
        if (nome.isEmpty()) {
            while (nome.isEmpty()) {
                nome = JOptionPane.showInputDialog("Digite o nome do seu time");
            }
        }

        tw.getTimes().stream().filter((timeJogo) -> (timeJogo.getNome().equalsIgnoreCase(nome))).forEachOrdered((TimeJogo _item) -> {
            nome = JOptionPane.showInputDialog(null, "Esse time já existe!");
        });
        t.setNome(nome);
        t.setJogadores(null);
        t.setQtdPerdeu(0);
        t.setQtdVenceu(0);
        times.add(t);
        t = new TimeJogo();

        tw.setTimes(times);
        try {
            File file = new File("src/com/acme/xml/times.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TimeJogoWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(tw, file);

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!!!");

            JAXBContext context = JAXBContext.newInstance(TimeJogoWrapper.class);
            Unmarshaller unm = context.createUnmarshaller();
            tw = (TimeJogoWrapper) unm.unmarshal(file);
            jfxcbSelectTime.getItems().clear();
            jfxcbSelectTime.setItems(FXCollections.observableArrayList(tw.getTimes()));
            jfxcbSelectTime.setConverter(new StringConverter<TimeJogo>() {
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

    @FXML
    private void handleDeleteJogadorAction(ActionEvent event) {
    }

    @FXML
    private void handleMoveJogadorAction(ActionEvent event) {
    }

    @FXML
    private void handleAddJogadorAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Jogadores.fxml"));
            Parent root1;
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Escalador de Times");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(TimesHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
