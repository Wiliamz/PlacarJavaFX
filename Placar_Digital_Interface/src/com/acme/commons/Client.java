/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.commons;

import com.acme.model.MessageObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Gabriel Cardoso
 */
public class Client {
    
    public static void rodar(String host) throws IOException {
        try {

            // Ip do host ---- pegará por texto, por enquanto só teste
            InetAddress ip = InetAddress.getByName(host);

            // estabelece conexão com servidor na porta 5056
            Socket s = new Socket(ip, 5056);

            // pega os input e outputStreams
            ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream dis = new ObjectInputStream(s.getInputStream());

            // Troca infos do cliente com o handle(o while true é para executar forever)
            while (true) {
                Object obj = dis.readObject();
                MessageObject msg = (MessageObject) obj;
                System.out.println(msg);
                if (msg.message.equals("Exit")) {
                    break;
                }
            }

            // Mata Tuto
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
