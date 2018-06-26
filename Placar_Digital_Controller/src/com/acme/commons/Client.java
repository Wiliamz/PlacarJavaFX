/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.commons;

import com.acme.enums.Acoes;
import com.acme.model.JogoDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public static OutputStreamWriter paraServer;
    public static InputStreamReader streamReader;

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
        paraServer = new OutputStreamWriter(s.getOutputStream());
        streamReader = new InputStreamReader(s.getInputStream());

        // Troca infos do cliente com o handle(o while true é para executar forever)
        while (true) {
            BufferedReader reader = new BufferedReader(streamReader);
            String msg = reader.readLine();
            System.out.println("mensageeeeeeem " + msg);
        }
    }

    public static void enviarMsg(String obj) {
        try {
            Client.paraServer.write(obj);
            Client.paraServer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void maisPonto() {
        Client.enviarMsg(Utils.metodoBackEncoder(Acoes.ADD_PONTOS_A));
    }
}
