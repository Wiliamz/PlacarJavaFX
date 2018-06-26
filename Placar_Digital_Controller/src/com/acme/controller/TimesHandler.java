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
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
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
public class TimesHandler implements Initializable {

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
    private JFXComboBox<TimeJogo> jfxcbSelecionarTime;
    private TableView<Jogador> jfxtcJogadores;
    @FXML
    private TableView<Jogador> jfxtcJogadoresEscalados;
    @FXML
    private JFXButton jfxbtnConcluido;
    @FXML
    private AnchorPane jfxapTimes;

    TimeJogo t = new TimeJogo();
    TimeJogoWrapper tw = new TimeJogoWrapper();
    JogadoresWrapper pw = new JogadoresWrapper();
    ArrayList<TimeJogo> times = new ArrayList();
    String nome;
    TableColumn<Jogador, String> colunaJogadores = new TableColumn<>("Jogador");

    private static ADMStartController admSC;

    public static void receberInstancia(ADMStartController adm) {
        admSC = adm;
    }
    @FXML
    private JFXListView<String> jfxlvJogadores;
    @FXML
    private JFXButton jfxbtnAtt;

    @FXML
    private void handlejfxbtnAddTeamAction(ActionEvent event) throws PropertyException {

        //Fazer método que confere se o Time já não existe!
        loadTeams();
        times = tw.getTimes();

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
        t.setId(tw.getTimes().size());
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

            loadTeams();

        } catch (JAXBException ex) {
            Logger.getLogger(ADMStartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleDeleteJogadorAction(ActionEvent event) {
    }

    @FXML
    private void handleMoveJogadorAction(ActionEvent event) {
        loadTeams();

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
            Logger.getLogger(TimesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSelecionarTimeAction(ActionEvent event) {

        TimeJogo time = jfxcbSelecionarTime.getSelectionModel().getSelectedItem();
        loadPlayers();

        jfxlvJogadores.getItems().clear();
        for (Jogador jogador : time.getJogadores()) {
            if (jogador.getTime() == time.getId()) {
                jfxlvJogadores.getItems().addAll(jogador.getNome());
            }
        }
    }

    @FXML
    private void handlejfxbtnConcluidoAction(ActionEvent event) {
        admSC.loadTeams();
        admSC.times.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadTeams() {
//        if(jfxrbBasquete.isSelected()){
//            
//        }else {
//            
//        }

        Platform.runLater(() -> {
            try {
                File arqxml = new File("src/com/acme/xml/times.xml");
                jfxcbSelecionarTime.getItems().clear();
                JAXBContext context = JAXBContext.newInstance(TimeJogoWrapper.class);
                Unmarshaller unm = context.createUnmarshaller();
                tw = (TimeJogoWrapper) unm.unmarshal(arqxml);
                jfxcbSelecionarTime.setItems(FXCollections.observableArrayList(tw.getTimes()));
                jfxcbSelecionarTime.setConverter(new StringConverter<TimeJogo>() {
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

    public void loadPlayers() {
//        if(jfxrbBasquete.isSelected()){
//            
//        }else {
//            
//        }

        Platform.runLater(() -> {
            try {
                File arqxml = new File("src/com/acme/xml/jogadores.xml");
                
                JAXBContext context = JAXBContext.newInstance(JogadoresWrapper.class);
                Unmarshaller unm = context.createUnmarshaller();
                pw = (JogadoresWrapper) unm.unmarshal(arqxml);
            } catch (JAXBException ex) {
                Logger.getLogger(ADMStartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
