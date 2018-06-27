/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.MainApp;
import com.acme.commons.Client;
import com.acme.commons.Observer;
import com.acme.enums.TipoUsuario;
import com.acme.model.JogadoresWrapper;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * FXML Controller class
 *
 * @author wiliam
 */
public class ADMStartController extends Observer implements Initializable {

    static Stage stage;

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
    @FXML
    private JFXComboBox<TimeJogo> JfxCbTimeB;
    @FXML
    private ToggleGroup tgEsporte;

    public Stage times;
    private static TimeJogoWrapper tw = new TimeJogoWrapper();
    private static JogadoresWrapper pw = new JogadoresWrapper();

    public ADMStartController(Stage stage) {
        this.stage = stage;
        Client.getJogo().attach(this);
    }

    @FXML
    private void handleEscalarTimeAction(ActionEvent event) {
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
            Logger.getLogger(ADMStartController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleEditTimeAction(ActionEvent event) {
        try {
            TimesHandler.receberInstancia(this);

            FXMLLoader fxmlLoader = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Times.fxml"));
            Parent root1;

            root1 = (Parent) fxmlLoader.load();

            times = new Stage();
            times.setTitle("Escalador de Times");
            times.setScene(new Scene(root1));
            times.show();

            times.setOnCloseRequest(evento -> {
                loadTeams();
            });
        } catch (IOException ex) {
            Logger.getLogger(ADMStartController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handlejfxrbBasqueteAction(ActionEvent event) {
        loadTeams();
    }

    @FXML
    private void handlejfxrbFutebolAction(ActionEvent event) {
        loadTeams();
        loadPlayers();
    }

    public void loadPlayers() {
        try {
            loadTeams();
            for (int i = 0; i < tw.getTimes().size(); i++) {
                pw.getJogadores().addAll(tw.getTimes().get(i).getJogadores());
            }
            File arqxml = new File("src/com/acme/xml/jogadores.xml");
            JAXBContext jaxbContextJogadores = JAXBContext.newInstance(JogadoresWrapper.class);
            Marshaller jaxbMarshallerJ = jaxbContextJogadores.createMarshaller();
            jaxbMarshallerJ.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshallerJ.marshal(pw, arqxml);
            JAXBContext context = JAXBContext.newInstance(JogadoresWrapper.class);
            Unmarshaller unm = context.createUnmarshaller();
            pw = (JogadoresWrapper) unm.unmarshal(arqxml);

        } catch (JAXBException ex) {
            Logger.getLogger(ADMStartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadTeams() {
//        if(jfxrbBasquete.isSelected()){
//            
//        }else {
//            
//        }

        try {
            File arqxml = new File("src/com/acme/xml/times.xml");
            JfxCbTimeA.getItems().clear();
            JfxCbTimeB.getItems().clear();
            JAXBContext context = JAXBContext.newInstance(TimeJogoWrapper.class);
            Unmarshaller unm = context.createUnmarshaller();
            tw = (TimeJogoWrapper) unm.unmarshal(arqxml);
            JfxCbTimeA.setItems(FXCollections.observableArrayList(tw.getTimes()));
            JfxCbTimeB.setItems(FXCollections.observableArrayList(tw.getTimes()));
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
            JfxCbTimeB.setConverter(new StringConverter<TimeJogo>() {
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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTeams();
        loadPlayers();
        JfxTfTempo.setText("05-00");
    }

    @FXML
    private void handleStartGame(ActionEvent event) {
        JFXRadioButton tipoJogo = (JFXRadioButton) jfxrbBasquete.getToggleGroup().getSelectedToggle();
        Client.startGame(tipoJogo.getText(), JfxTfTempo.getText(), JfxCbTimeA.getValue().getNome(), JfxCbTimeB.getValue().getNome());

    }

    @Override
    public void update() {
        Observer obs = this;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (Client.getJogo().isJogando()) {
                    FXMLLoader fxmlLoader = null;
                    if (Client.getJogo().getTipoJogo().equalsIgnoreCase("Basquete")) {
                        fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/JuizBasquete.fxml"));
                    } else {
                        fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/JuizFutebol.fxml"));
                    }
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
                    Client.getJogo().removeObserver(obs);
                    ADMStartController.stage.close();
                }
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
