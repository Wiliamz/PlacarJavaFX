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
import com.jfoenix.controls.JFXListView;
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
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
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
    private JFXComboBox<TimeJogo> jfxcbSelecionarTime;
    private TableView<Jogador> jfxtcJogadores;
    @FXML
    private JFXButton jfxbtnConcluido;
    @FXML
    private AnchorPane jfxapTimes;
    @FXML
    private JFXListView<String> jfxlvJogadores;
    @FXML
    private JFXListView<String> jfxlvJogadoresEscalados;
    @FXML
    private JFXButton jfxbtnAtt;

    TimeJogo t = new TimeJogo();
    TimeJogoWrapper tw = new TimeJogoWrapper();
    JogadoresWrapper pw = new JogadoresWrapper();
    ArrayList<TimeJogo> times = new ArrayList();
    String nome;
    public Stage jogadores;

    private static ADMStartController admSC;

    public static void receberInstancia(ADMStartController adm) {
        admSC = adm;
    }
    @FXML
    private JFXButton jfxbtnDeleteJogadorEscalado;

    @FXML
    private void handlejfxbtnAddTeamAction(ActionEvent event) throws PropertyException {

        //Fazer método que confere se o Time já não existe!
        loadTeams();
        times = tw.getTimes();
        nome = JOptionPane.showInputDialog("Digite o nome do seu time");
        t.setNome(nome);
        t.setId(tw.getTimes().size());
        t.setJogadores(null);
        t.setQtdPerdeu(0);
        t.setQtdVenceu(0);

        if (nome.isEmpty()) {
            while (nome.isEmpty()) {
                nome = JOptionPane.showInputDialog("Digite o nome do seu time");
            }
        } else {
            times.stream().filter((time) -> (tw.getTimes().get(time.getId()).getNome().equalsIgnoreCase(nome))).forEachOrdered((time) -> {
                while (tw.getTimes().get(time.getId()).getNome().equalsIgnoreCase(nome)) {
                    nome = JOptionPane.showInputDialog(null, "Esse time já existe!");
                }
            });
            times.add(t);
            t = new TimeJogo();
            tw.setTimes(times);
            saveTeams();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!!!");
            loadTeams();
        }
    }

    @FXML
    private void handleDeleteJogadorAction(ActionEvent event) {
        if (jfxcbSelecionarTime.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Time selecionado!");
        } else if (jfxlvJogadores.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Jogador selecionado!");
        } else {
            TimeJogo time = jfxcbSelecionarTime.getSelectionModel().getSelectedItem();
            String nomeJogador = jfxlvJogadores.getSelectionModel().getSelectedItem();
            time.getJogadores().stream().filter((j) -> (j.getNome().equals(nomeJogador) && j.getTime() == time.getId())).forEachOrdered((j) -> {
                time.getJogadores().remove(j);
            });
            saveTeams();
            savePlayers();
            loadPlayers();
        }
    }

    @FXML
    private void handleMoveJogadorAction(ActionEvent event) {
        if (jfxcbSelecionarTime.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Time selecionado!");
        } else if (jfxlvJogadores.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Jogador selecionado!");
        } else {
            TimeJogo time = jfxcbSelecionarTime.getSelectionModel().getSelectedItem();
            String nomeJogador = jfxlvJogadores.getSelectionModel().getSelectedItem();
            time.getJogadores().stream().filter((j) -> (j.getNome().equals(nomeJogador) && j.getTime() == time.getId())).forEachOrdered((j) -> {
                if (admSC.jfxrbBasquete.isSelected()) {
                    if (jfxlvJogadoresEscalados.getItems().size() >= 5) {
                        JOptionPane.showMessageDialog(null, "Você não pode adicionar mais que 5 jogadores para jogar!");
                    } else if (jfxlvJogadoresEscalados.getItems().isEmpty()) {
                        jfxlvJogadoresEscalados.getItems().add(j.getNome());
                    } else if (jfxlvJogadoresEscalados.getItems().contains(nomeJogador)) {
                        JOptionPane.showMessageDialog(null, "Jogador já está na escalação!");
                    } else {
                        jfxlvJogadoresEscalados.getItems().add(j.getNome());
                    }
                } else if (admSC.jfxrbFutebol.isSelected()) {
                    if (jfxlvJogadoresEscalados.getItems().size() >= 11) {
                        JOptionPane.showMessageDialog(null, "Você não pode adicionar mais que 11 jogadores para jogar!");
                    } else if (jfxlvJogadoresEscalados.getItems().isEmpty()) {
                        jfxlvJogadoresEscalados.getItems().add(j.getNome());
                    } else if (jfxlvJogadoresEscalados.getItems().contains(nomeJogador)) {
                        JOptionPane.showMessageDialog(null, "Jogador já está na escalação!");
                    } else {
                        jfxlvJogadoresEscalados.getItems().add(j.getNome());
                    }
                }

            }
            );
        }
    }

    @FXML
    private void handleAddJogadorAction(ActionEvent event) {
        try {
            JogadoresController.receberInstancia(this);
            FXMLLoader fxmlLoader = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/com/acme/view/Jogadores.fxml"));
            Parent root1;
            root1 = (Parent) fxmlLoader.load();
            jogadores = new Stage();
            jogadores.setTitle("Escalador de Times");
            jogadores.setScene(new Scene(root1));
            jogadores.show();
            jogadores.setOnCloseRequest(evento -> {
                loadTeams();
                loadPlayers();
            });

        } catch (IOException ex) {
            Logger.getLogger(TimesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSelecionarTimeAction(ActionEvent event) {

        TimeJogo time = jfxcbSelecionarTime.getSelectionModel().getSelectedItem();
        loadPlayers();

        jfxlvJogadores.getItems().clear();
        time.getJogadores().stream().filter((jogador) -> (jogador.getTime() == time.getId())).forEachOrdered((jogador) -> {
            jfxlvJogadores.getItems().addAll(jogador.getNome());
        });
    }

    @FXML
    private void handlejfxbtnConcluidoAction(ActionEvent event) {
        admSC.loadTeams();
        admSC.times.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTeams();
        loadPlayers();
    }

    public void saveTeams() {
        try {
            File file = new File("src/com/acme/xml/times.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TimeJogoWrapper.class
            );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(tw, file);

        } catch (JAXBException ex) {
            Logger.getLogger(TimesHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void savePlayers() {
        try {
            File file = new File("src/com/acme/xml/jogadores.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(JogadoresWrapper.class
            );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(pw, file);

        } catch (JAXBException ex) {
            Logger.getLogger(TimesHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
                JAXBContext context = JAXBContext.newInstance(TimeJogoWrapper.class
                );
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
                Logger.getLogger(ADMStartController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void loadPlayers() {

        Platform.runLater(() -> {
            try {
                File arqxml = new File("src/com/acme/xml/jogadores.xml");
                JAXBContext context = JAXBContext.newInstance(JogadoresWrapper.class
                );
                Unmarshaller unm = context.createUnmarshaller();
                pw = (JogadoresWrapper) unm.unmarshal(arqxml);

            } catch (JAXBException ex) {
                Logger.getLogger(ADMStartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void handleDeleteJogadorEscaladoAction(ActionEvent event) {
        if (jfxcbSelecionarTime.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Time selecionado!");
        } else if (jfxlvJogadoresEscalados.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há Jogador selecionado!");
        } else {
            TimeJogo time = jfxcbSelecionarTime.getSelectionModel().getSelectedItem();
            String nomeJogador = jfxlvJogadoresEscalados.getSelectionModel().getSelectedItem();
            jfxlvJogadoresEscalados.getItems().remove(nomeJogador);
        }
    }
}
