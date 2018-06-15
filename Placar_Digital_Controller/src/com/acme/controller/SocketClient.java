package com.acme.controller;

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
public class SocketClient {

    public static void executar() throws IOException {
        try {

            // Ip do host
            InetAddress ip = InetAddress.getByName("localhost");

            // Coencta na porta 5056
            Socket s = new Socket(ip, 5056);

            // Pega os input e out streams
            ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream dis = new ObjectInputStream(s.getInputStream());

            // Loop para trocar dados com o clientHandler
            while (true) {
                Object obj = dis.readObject();
                MessageObject msg = (MessageObject) obj;
                System.out.println(msg);
                if (msg.message.equals("Exit")) {
                    break;
                }
            }

            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
