/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

import com.acme.commons.Client;
import com.acme.commons.Utils;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Mateus PDK
 */
public class PlacarFutebolController extends com.acme.commons.Observer implements Initializable {

    @FXML
    private Pane panead;
    @FXML
    private ImageView imagead;
    @FXML
    private Button btnSetImg;
    @FXML
    private Label lbladvertise;

    String adencoded;
    private String base64Image;

    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    double screenH = screenBounds.getHeight();
    double screenW = screenBounds.getWidth();

    @FXML
    private GridPane placarfutebolcontainer;

    String sourceData = "";
    @FXML
    private Label lblTempo;
    @FXML
    private Label lblTimeA;
    @FXML
    private Label lblPontosA;
    @FXML
    private Label lblPontosB;
    @FXML
    private Label lblTempoTotal;
    @FXML
    private Label lblTimeB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public PlacarFutebolController() {
        Client.getJogo().attach(this);
    }

    @FXML
    public void showAd() {
        String[] parts = sourceData.split(";");
        String imageString = parts[1];
//        String[] parts = sourceData.split(",");
//        String imageString = sourceData;
        // create a buffered image  
        byte[] imageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(imageString);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(imageByte));
        } catch (IOException ex) {
            Logger.getLogger(PlacarFutebolController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        imagead.toFXImage(java.awt.image.BufferedImage bimg, WritableImage wimg);
        try {
            WritableImage advertise = SwingFXUtils.toFXImage(img, null);
            imagead.setImage(advertise);
        } catch (Exception e) {
            System.out.println(e);
        }

        imageSlider();
    }

    public void triggerTextAd() {
        textSlider("TAFAREEEEEEEEEEEEEEEEEEEEEEEL !!!");
    }

    public void textSlider(String textoAd) {
        lbladvertise.setText(textoAd);
        TranslateTransition slide = new TranslateTransition();
        slide.setCycleCount(3);
//          slide.setDelay(Duration.seconds(1));
        slide.setNode(lbladvertise);
        slide.setFromX(screenW);
        slide.setDuration(Duration.seconds(10));
        double textWidth = (screenW * 2) * -1;
        slide.setToX(textWidth);
        slide.play();
//        slide.setOnFinished();
//        slide.onFinishedProperty();
    }

    public void limpaText() {
        lbladvertise.setText("");
    }

    public void imageSlider() {
        TranslateTransition slide = new TranslateTransition();
        slide.setCycleCount(10);
//          slide.setDelay(Duration.seconds(1));
        slide.setNode(imagead);
        slide.setFromX(screenW);
        slide.setDuration(Duration.seconds(5));
        slide.setToX(-screenW);
        slide.play();
    }

    public void atualizarTela() {
        Platform.runLater(() -> {
            lblPontosA.setText(String.valueOf(Client.getJogo().getPontosA()));
            lblPontosB.setText(String.valueOf(Client.getJogo().getPontosB()));
            lblTimeA.setText(Client.getJogo().getTimeA());
            lblTimeB.setText(Client.getJogo().getTimeB());
            lblTempoTotal.setText(Utils.formatSecondsToSTring(Client.getJogo().getTempoDecorrido()));
            lblTempo.setText((Client.getJogo().getTempoDecorrido() > (Client.getJogo().getTempoEstimado() / 2)) ? "2" : "1");
            if (!sourceData.equals(Client.getJogo().getBase64Image())) {
                sourceData = Client.getJogo().getBase64Image();
                if (sourceData.startsWith(";")) {
                    showAd();
                } else {
                    textSlider(sourceData);
                }
//                showAd();
            }
            Utils.verificarFinal();
        });
    }

    @Override
    public void update() {
        atualizarTela();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
