/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

// ClientHandler class
import com.acme.commons.Server;
import com.acme.enums.Acoes;
import com.acme.model.JogoDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ClientHandler extends Thread implements Serializable {

//    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
//    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    OutputStreamWriter paraServer;
    InputStreamReader streamReader;
    BufferedReader reader;
    PrintWriter writer;
//                BufferedReader reader = new BufferedReader(streamReader);

//                paraServer.write("Minha mensagem\n");
//                paraServer.flush();
//                String msg = reader.readLine();
//    ObjectOutputStream dos;
//    ObjectInputStream dis;
    final Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
//        this.dos = new ObjectOutputStream(socket.getOutputStream());
//        this.dis = new ObjectInputStream(socket.getInputStream());
//        this.paraServer = new OutputStreamWriter(socket.getOutputStream());
        writer = new PrintWriter(socket.getOutputStream());
        this.streamReader = new InputStreamReader(socket.getInputStream());
        this.reader = new BufferedReader(streamReader);
    }

    public void sendMessage(String msg) {
        //            if (socket.isClosed()) {
//                Server.getInstance().getClients().remove(this);
//                return;
//            }
//            dos.writeObject(msg);

        writer.println(msg);
        writer.flush();
    }

    @Override
    public void run() {
//        Server.getInstance().avisaTodos();
        while (true) {
            try {
//                Object obj = dis.readObject();

//                if (obj instanceof JogoDto) {
                String obj = reader.readLine();

//                } else if (obj instanceof String) {
                System.out.println("Mensagem Front" + obj);
                if (obj.equals(Acoes.ADD_PONTOS_A)) {
                    Server.addPontosA();
//                    }
                }
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
