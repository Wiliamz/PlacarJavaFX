/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import com.acme.commons.Server;
import com.acme.commons.TipoUsuario;
import com.acme.commons.Utils;
import com.acme.model.Usuario;
import com.acme.model.UsuarioWrapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Mateus PDK
 */
public class MainApp extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
//
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //                try {
//                    Server.rodar();
//                } catch (IOException ex) {
//                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        
         Task task = new Task<Void>() {
            @Override
            public Void call() {
                try {
                    Server.rodar();
                } catch (IOException ex) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        new Thread(task).start();

        Parent fxmlCena = FXMLLoader.load(this.getClass().getResource("/com/acme/view/LoginController.fxml"));
        Scene cena = new Scene(fxmlCena);
        primaryStage.setScene(cena);
        primaryStage.show();
        stage = primaryStage;

//        try {
//            Usuario u = new Usuario("admin", Utils.gerarMd5("essanaoeasenha"), TipoUsuario.ADMIN);
//            Usuario u2 = new Usuario("marketing", Utils.gerarMd5("shazam"), TipoUsuario.MARKETING);
//            Usuario u3 = new Usuario("juiz", Utils.gerarMd5("oleleolala"), TipoUsuario.JUIZ);
//            UsuarioWrapper uw = new UsuarioWrapper(u);
//            
//            uw.addUsuario(u2);
//            uw.addUsuario(u3);
//            File file = new File("src/com/acme/xml/usuarios.xml");
//            JAXBContext jaxbContext;
//            jaxbContext = JAXBContext.newInstance(UsuarioWrapper.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(uw, file);
//            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!!!");
//        } catch (JAXBException ex) {
//            ex.printStackTrace();
////                Logger.getLogger(MesaController.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar o arquivo :(");
//        }
//        Server.rodar();
//        StackPane root = new StackPane();
//        Rectangle2D r = Screen.getPrimary().getBounds();
//        
//        cena.getStylesheets().add(getClass().getResource("/com/acme/resources/css/style.css").toExternalForm());
//
//        System.out.println("x: "+r.getWidth()+" y: "+r.getHeight());
//
//        Rectangle rect = new Rectangle(r.getWidth(), r.getHeight());
//        root.getChildren().add(rect);
        // scene.setCursor(Cursor.NONE);  // Uncomment, if you don't need a cursor
//        primaryStage.setFullScreen(true);
//        Parent fxmlCena = FXMLLoader.load(this.getClass().getResource("/com/acme/view/Placar.fxml"));
//        Scene cena = new Scene(fxmlCena);
//        primaryStage.setScene(cena);
//        primaryStage.setResizable(false);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.setFullScreen(true);
//        primaryStage.show();;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
