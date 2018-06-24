/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

// ClientHandler class
import com.acme.commons.Server;
import com.acme.model.JogoDto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ClientHandler extends Thread implements Serializable {

//    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
//    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    ObjectOutputStream dos;
    ObjectInputStream dis;
    final Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.dos = new ObjectOutputStream(socket.getOutputStream());
        this.dis = new ObjectInputStream(socket.getInputStream());
    }

    public void sendMessage(Object msg) {
        try {
//            if (socket.isClosed()) {
//                Server.getInstance().getClients().remove(this);
//                return;
//            }
            dos.writeObject(msg);
            dos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
//        Server.getInstance().avisaTodos();
        while (true) {
            try {
                System.out.println("ishi");
                Object obj = dis.readObject();
                if (obj instanceof JogoDto) {

                } else if (obj instanceof String) {
                    System.out.println("ONJTECTO" + obj);
                    if (obj.equals("addPontosA")) {
                        Server.addPontosA();
                    }
                }
                System.out.println("CLASSE" + obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//
//        try {
//            Server.clients.remove(this);
//            this.dis.close();
//            this.dos.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
