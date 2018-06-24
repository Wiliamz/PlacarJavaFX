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

    private static Server instancia = null;
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
        System.out.println("Server running on port 5056");

        // running infinite loop for getting
        // client request
        while (true) {
            Socket socket = null;

            try {
                // Objeto socket para receber mensagens do cliente
                socket = serverSocket.accept();

                System.out.println("A new client is connected : " + socket);

                // Obter input e outputStreams
                System.out.println("Assigning new thread for this client");

                // Novo objeto thread
                ClientHandler client = new ClientHandler(socket);
                client.start();
                for (int i = 0; i < 3; i++) {
                    client.sendMessage(new JogoDto());
                }
                clients.add(client);
                clients.add(client);
                clients.add(client);
                // chama o start
            } catch (Exception e) {
//                socket.close();
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

    public static synchronized Server getInstance() {
        if (instancia == null) {
            instancia = new Server();
        }
        return instancia;
    }
//
//    public static void rodar() throws IOException {
//        
//    }
//    

    public static void addPontosA() {
//        Server.getInstance().jogo.addPontosA();
        System.out.println("SIZE" + getClients().size() + " JOGooOOOO " + Server.getJogo().getPontosA());
        for (ClientHandler c : getClients()) {
//            c.sendMessage(Server.getInstance().jogo);
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
