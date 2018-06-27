/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.controller;

// ClientHandler class
import com.acme.commons.Server;
import com.acme.commons.Utils;
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

    OutputStreamWriter paraServer;
    InputStreamReader streamReader;
    BufferedReader reader;
    PrintWriter writer;
    final Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        writer = new PrintWriter(socket.getOutputStream());
        this.streamReader = new InputStreamReader(socket.getInputStream());
        this.reader = new BufferedReader(streamReader);
    }

    public void sendMessage(String msg) {
        writer.println(msg);
        writer.flush();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String obj = reader.readLine();
                System.out.println("Mensagem Front" + obj);
                Utils.callServerMethod(obj);
//                System.out.println("Acoes.valueOf(obj)" + Acoes.valueOf(obj));
//                switch (Acoes.valueOf(obj)) {
//                    case PAUSE:
//                        Server.pauseGame();
////                        Client.jogo.setPausado(true);
//                        break;
//                    case ADD_PONTOS_A:
//                        Server.addPontosA();
//                }
                
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
