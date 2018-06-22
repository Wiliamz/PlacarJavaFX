package com.acme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class AdministradorController {

    @FXML
    private Label JLGoalTimeA;

    @FXML
    private Label JLTempo;

    @FXML
    private Label JLGoalTimeB;

    @FXML
    private Label JLProrroga;

    @FXML
    private JFXButton JBStopGame;

    @FXML
    private JFXButton JBPlayGame;

    @FXML
    private JFXTextField JTFTempParaProrro;

    @FXML
    private JFXButton JBAddProrroga;

    @FXML
    private JFXButton JBEndGame;

    @FXML
    private JFXButton JBAddGoalA;

    @FXML
    private JFXButton JBRemoveGoalA;

    @FXML
    private JFXButton JBMarcarFaultaA;

    @FXML
    private JFXButton JBAddGoalB;

    @FXML
    private JFXButton JBRemoveGoalB;

    @FXML
    private JFXButton JBMarcarFaultaB;

    @FXML
    private JFXButton JBStartGame;

    int goalsA = 0;
    int goalsB = 0;

    private long mil;
    private int mile;
    private int cent;
    private int seg;
    private int min;
    private long inicio;
    String tempo = "";

    @FXML
    void JBAddGoalAAction(ActionEvent event) {
        goalsA = goalsA + 1;
        JLGoalTimeA.setText("" + goalsA);
    }

    @FXML
    void JBAddGoalBAction(ActionEvent event) {
        goalsB = goalsB + 1;
        JLGoalTimeB.setText("" + goalsB);
    }

    @FXML
    void JBAddProrrogaAction(ActionEvent event) {

    }

    @FXML
    void JBEndGameAction(ActionEvent event) {
        JLTempo.setText("Okay");
    }

    @FXML
    void JBMarcarFaultaAAction(ActionEvent event) {

    }

    @FXML
    void JBPlayGameAction(ActionEvent event) {

    }

    @FXML
    void JBRemoveGoalAAction(ActionEvent event) {
        if (goalsA < 1) {
            JOptionPane.showMessageDialog(null, "Não tem como por gols negativos");
        } else {
            goalsA = goalsA - 1;
        }
        JLGoalTimeA.setText("" + goalsA);
    }

    @FXML
    void JBRemoveGoalBAction(ActionEvent event) {
        if (goalsB < 1) {
            JOptionPane.showMessageDialog(null, "Não tem como por gols negativos");
        } else {
            goalsB = goalsB - 1;
        }
        JLGoalTimeB.setText("" + goalsB);
    }

    @FXML
    void JBStartGameAction(ActionEvent event) {
        crono();

    }

    @FXML
    void JBStopGameAction(ActionEvent event) {

    }

    void cronometro() {
        //inicio a contagem
        inicio = System.currentTimeMillis();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    void crono() {  //start eu recebo da minha frame

        Timeline time;
        time = new Timeline(new KeyFrame(
                Duration.ZERO, (ActionEvent ae) -> {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                //se start for true faça, inicio meu laço ate start ficar falso

                                mil = System.currentTimeMillis();
                                mil = mil - inicio; //tira a diferença do tempo inicial com o tempo atual
                                //contador dos milesegundos
                                if (mile < 1000) {
                                    mile++;
                                } else {
                                    mile = 0;
                                    cent++;
                                }
                                //conta os segundos e zera os centesimos
                                if (cent >= 99) {
                                    cent = 0;
                                    seg++;
                                }
                                //conta os minutos e zera o segundos
                                if (seg >= 59) {
                                    seg = 0;
                                    min++;
                                }
                                //passa para o formato correto
                                if (min < 10) {
                                    min = Integer.parseInt("0" + String.valueOf(min));
                                }
                                if (seg < 10) {
                                    seg = Integer.parseInt("0" + String.valueOf(seg));
                                }
                                if (cent < 10) {
                                    cent = Integer.parseInt("0" + String.valueOf(cent));
                                }
                                //concatena
                                tempo = String.valueOf(min) + ":" + String.valueOf(seg) + ":" + String.valueOf(cent);
                                JLTempo.setText(String.valueOf(min) + ":" + String.valueOf(seg) + ":" + String.valueOf(cent));
                                System.out.println(tempo);
                            }

                        }
                    });
                    t.start();

                }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();

    }

}
