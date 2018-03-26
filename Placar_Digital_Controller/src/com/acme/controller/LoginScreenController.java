package com.acme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

public class LoginScreenController {

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXTextField tfUsername;

    @FXML
    private JFXPasswordField pfPassword;

    @FXML
    private JFXTextField tfIp;

    @FXML
    public CheckBox cbRememberme;

    @FXML
    public Label lForgotmysenha;

    @FXML
    private JFXButton bExit;

    @FXML
    void bExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnSignInAction(ActionEvent event) {

        if(tfIp.getText().contentEquals("192.168.0.1")||tfUsername.getText().contentEquals("admin")||pfPassword.getText().contentEquals("123")){
            JOptionPane.showMessageDialog(null, "Você logou com sucesso!");
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Você não conseguiu logar!", "Alerta", 2);
        }
        
    }

    @FXML
    void cbRemembermeAction(ActionEvent event) {

        tfIp.setText("192.168.0.1");
        tfUsername.setText("admin");
        pfPassword.setText("123");
                
    }

}
