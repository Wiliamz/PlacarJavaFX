/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.commons.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Cardoso
 */
public class LoginController {

    @FXML
    private JFXButton btnSignIn;
    
    @FXML
    private JFXTextField txtIp;
    
      @FXML
    void bExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnSignInAction(ActionEvent event) {
        System.out.println("IPPPPP" + txtIp.getText());
        try{
        Client.rodar(txtIp.getText());
        }catch(Exception e) {
        e.printStackTrace();}
    }

}
