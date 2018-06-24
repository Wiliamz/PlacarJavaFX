/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.commons;

import com.acme.model.JogoDto;
import com.acme.model.MessageObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cardoso
 */
public class Client {

    public static ObjectOutputStream dos;
    public static ObjectInputStream dis;

    private static JogoDto jogo;

    public static JogoDto getJogo() {
        return jogo;
    }

    public static void rodar(String host) throws IOException, ClassNotFoundException, UnknownHostException {

        // Ip do host ---- pegará por texto, por enquanto só teste
        InetAddress ip = InetAddress.getByName(host);

        // estabelece conexão com servidor na porta 5056
        Socket s = new Socket(ip, 5056);
        jogo = new JogoDto();

        // pega os input e outputStreams
//        ObjectInputStream dis = new ObjectInputStream(s.getInputStream());
        dos = new ObjectOutputStream(s.getOutputStream());
        dis = new ObjectInputStream(s.getInputStream());
// FUNCIONA =-------------------------------
//        OutputStreamWriter paraServer = new OutputStreamWriter(s.getOutputStream());
//        InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
//        BufferedReader reader = new BufferedReader(streamReader);
// -------------------
        // Troca infos do cliente com o handle(o while true é para executar forever)
        while (true) {
            Object obj = dis.readObject();
            if (obj instanceof JogoDto) {
                JogoDto j = (JogoDto) dis.readObject();
                System.out.println("JOGO NO CLIENT.JAVA " + j.getPontosA());
            } else {
                System.out.println("INSTANCIA " + obj.getClass().getName());
            }

            //Funciona ---------------------------------
//            String msg = reader.readLine();
//                System.out.println("mensageeeeeeem " + msg);
// ------------------------------------------------
//            Object obj = dis.readObject();
//            JogoDto jogo = (JogoDto) obj;
//            System.out.println(jogo.getPontosA());
//            if (jogo.getMessage().equals("Exit")) {
//                break;
//            }
//            } else if (msg.message.equals("Logou")) {
//
//                System.out.println("maoeeee");
//            }
        }

        // Mata Tuto
//        dis.close();
//        dos.close();
    }

    public static void enviarMsg(Object obj) {
        try {
//            JogoDto j = new JogoDto();
//            j.setPontosA(Client.getJogo().getPontosA() + 1);
            Client.dos.writeObject(obj);
            Client.dos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void maisPonto() {
//        JogoDto j = new JogoDto();
//        j.setPontosA(Client.getJogo().getPontosA() + 1);
        Client.enviarMsg("addPontosA");
    }
}
