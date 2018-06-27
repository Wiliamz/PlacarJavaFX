/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import static com.acme.MainApp.stage;
import com.acme.commons.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Mateus PDK
 */
public class MarketingController implements Initializable {

    @FXML
    private Pane panepreview;
    @FXML
    private ImageView imagepreview;
    @FXML
    private JFXTextField txtTexto;
    @FXML
    private JFXButton btnChoseFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void choseAd(ActionEvent event) throws IOException {
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Escolher Imagem");
        File file = fileChooser.showOpenDialog(stage);
        Path path = Paths.get(file.getAbsolutePath());
        byte[] bytes = Files.readAllBytes(path);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encodedString = new String(encoded);
//        System.out.println(encodedString);
        Client.setImagem(";"+ encodedString);
       
//        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
//        return new String(encoded, StandardCharsets.US_ASCII);
    }

    @FXML
    private void enviarTexto(ActionEvent event) {
        Client.setImagem(txtTexto.getText());
    }
}
