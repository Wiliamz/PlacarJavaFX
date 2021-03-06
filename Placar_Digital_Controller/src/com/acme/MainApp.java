/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import com.acme.commons.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
//        System.out.println(Utils.gerarMd5("123"));
////        
//        int comServer = JOptionPane.showConfirmDialog(null, "Abrir server junto?");
//        if (comServer == 0) {
//            Task task = new Task<Void>() {
//                @Override
//                public Void call() {
//                    try {
//                        Server.rodar();
//                    } catch (IOException ex) {
//                        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    return null;
//                }
//            };
//            new Thread(task).start();
//        }

        Parent fxmlCena = FXMLLoader.load(this.getClass().getResource("/com/acme/view/LoginController.fxml"));
        Scene cena = new Scene(fxmlCena);
        primaryStage.setScene(cena);
        primaryStage.show();
        stage = primaryStage;
        //Método para adicionar icones na barra de tarefas
        Image icone = new Image("/com/acme/resources/icons/whistle32.png"); //Icone aleatório
        stage.getIcons().add(icone);
        

//                                          EXEMPLO SALVAR XML
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
