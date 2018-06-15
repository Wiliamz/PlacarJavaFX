package com.acme.controller;

import com.acme.commons.Server;
import com.acme.model.MessageObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Gabriel Cardoso
 */
public class ClientHandler extends Thread {

    ObjectInputStream dis;
    ObjectOutputStream dos;
    final Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.dis = new ObjectInputStream(socket.getInputStream());
        this.dos = new ObjectOutputStream(socket.getOutputStream());
    }

    public void sendMessage(MessageObject msg) {
        try {
            if (socket.isClosed()) {
                Server.clients.remove(this);
                return;
            }
            dos.writeObject(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        Server.avisaTodos();
        while (true) {
            try {
                Object obj = dis.readObject();
                if (obj instanceof MessageObject) {
                    MessageObject msg = (MessageObject) obj;
                    System.out.println("RECEBIDO: " + msg.message);
                    if (msg.message.equals("Exit")) {
                        System.out.println("Client " + this.socket + " mandou exit...");
                        System.out.println("Fechando a connection.");
                        this.socket.close();
                        System.out.println("Connection fechada");
                        break;
                    }
                } else {
                    System.out.println(obj.toString());
                }
            } catch (SocketException se) {
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Server.clients.remove(this);
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
