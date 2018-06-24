//ADICIONAR ESSA CARALHA NUM PROJETO NOVO DEPOIS PARA ENTREGAR E MOSTRAR
//GRATO DESDE JÁ
package com.acme.commons;

import com.acme.model.JogoDto;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.acme.controller.ClientHandler;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cardoso
 */
public final class Server {

//    private static Server instancia = null;
    private static final List<ClientHandler> clients = new ArrayList<>();
    private static JogoDto jogo;

    public Server() {
        // server is listening on port 5056
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5056);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        jogo = new JogoDto();
        System.out.println("Rodando na porta 5056");

        while (true) {
            Socket socket = null;
            try {
                // Objeto socket para receber mensagens do cliente
                socket = serverSocket.accept();

                System.out.println("Novo cliente conectado : " + socket);

                // Novo objeto client com nova thread
                ClientHandler client = new ClientHandler(socket);
                client.start();
                
                clients.add(client);
                for (int i = 0; i < 3; i++) {
                    client.sendMessage("iusisiuisuisu");
                }
            } catch (Exception e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                e.printStackTrace();
            }
        }
    }

    public static List<ClientHandler> getClients() {
        return clients;
    }

    public static JogoDto getJogo() {
        return jogo;
    }

//    public static synchronized Server getInstance() {
//        if (instancia == null) {
//            instancia = new Server();
//        }
//        return instancia;
//    }
//
//    public static void rodar() throws IOException {
//        
//    }
//    

    public static void addPontosA() {
        Server.jogo.addPontosA();
        System.out.println("SIZE Clientes" + getClients().size() + " Pontuacao Time A " + Server.getJogo().getPontosA());
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Server.jogo);
        }
    }
//    
//    public static void avisaTodos() {
//        for (ClientHandler c : getClients()) {
//            
//            
//            c.sendMessage(new MessageObject("Shazam Carai ta mandando pra geral seu dilho da trueta"));
//        }
//    }
//    
}
