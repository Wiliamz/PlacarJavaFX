package com.acme.controller;

import com.acme.model.JogoDto;
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

    public void sendMessage(JogoDto jogo) {
        System.out.println("JOGO" + jogo.getPontosA());
        try {
            if (socket.isClosed()) {
                Server.getClients().remove(this);
                return;
            }
            dos.writeObject(jogo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMessage(MessageObject msg) {
        try {
            if (socket.isClosed()) {
                Server.getClients().remove(this);
                return;
            }
            dos.writeObject(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
//        Server.avisaTodos();
//        if (Server.fazerLogin(this.login, this.senha)) {
        while (true) {
//            System.out.println("xi");
            try {
//                System.out.println("oioioi");
//                JogoDto msg = (JogoDto) dis.readObject();
                Object obj = dis.readObject();
//                MessageObject msg = (MessageObject) dis.readObject();
                if (obj instanceof JogoDto) {
//                    System.exit(0);
                    System.out.println("MEU CHAEUAH");
                    JogoDto msg = (JogoDto) obj;
                    System.out.println("RECEBIDO: " + msg.getPontosA());
                    if (msg.getMessage().equals("Exit")) {
                        System.out.println("Client " + this.socket + " mandou exit...");
                        System.out.println("Fechando a connection.");
                        this.socket.close();
                        System.out.println("Connection fechada");
                        break;
                    }
                } else {
                    System.out.println(obj.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("caiu essa merda ai meu");
            Server.getClients().remove(this);
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        } else {
//            Server.getClients().remove(this);
//        }
    }
//

}
