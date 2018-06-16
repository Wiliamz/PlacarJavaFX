//ADICIONAR ESSA CARALHA NUM PROJETO NOVO DEPOIS PARA ENTREGAR E MOSTRAR
//GRATO DESDE JÁ
package com.acme.commons;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.acme.controller.ClientHandler;
import com.acme.model.MessageObject;

/**
 *
 * @author Gabriel Cardoso
 */
public class Server {

    public static final List<ClientHandler> clients = new ArrayList<>();

    public static void rodar() throws IOException {
        // server is listening on port 5056
        ServerSocket serverSocket = new ServerSocket(5056);
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
                clients.add(client);
                // chama o start
                client.start();
            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }

    public static void avisaTodos() {
        for (ClientHandler c : clients) {
            c.sendMessage(new MessageObject("Miranha"));
        }
    }
}
