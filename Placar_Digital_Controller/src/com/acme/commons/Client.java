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
import java.util.HashMap;
import java.util.Set;
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
    
    private static JogoDto jogo = new JogoDto();
    
    public static JogoDto getJogo() {
        return jogo;
    }
    
    public static void rodar(String host) throws IOException, ClassNotFoundException, UnknownHostException {
        // Ip do host ---- pegará por texto, por enquanto só teste
        InetAddress ip = InetAddress.getByName(host);
        // estabelece conexão com servidor na porta 5056
        Socket s = new Socket(ip, 5056);

//        jogo = new JogoDto();
        paraServer = new OutputStreamWriter(s.getOutputStream());
        streamReader = new InputStreamReader(s.getInputStream());

        // Troca infos do cliente com o handle(o while true é para executar forever)
        while (true) {
            BufferedReader reader = new BufferedReader(streamReader);
            String msg = !reader.readLine().isEmpty() ? reader.readLine() : "";
            String[] valores = Utils.metodoFrontDecoder(msg);
//            Set keySet = hash.keySet();
//            if (keySet.size() > 0) {
//                Acoes acao = (Acoes) keySet.iterator().next();
            if (valores.length == 2) {
                try {
                    atualizarJogo(valores[0], valores[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            }
            System.out.println("mensageeeeeeem " + msg);
        }
    }
    
    public static void bindToJogo(Observer observer) {
        Client.jogo.attach(observer);
    }
    
    public static void enviarMsg(String obj) {
        try {
            Client.paraServer.write(obj);
            Client.paraServer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void startGame(String tipoJogo, String tempoJogo, String timeA, String timeB) {
        String params = Acoes.INICIAR_JOGO.name() + ";" + tipoJogo + ";" + tempoJogo + ";" + timeA + ";" + timeB;
        Client.enviarMsg(Utils.metodoBackEncoder(params));
        
    }
    
    public static void maisPonto() {
        Client.enviarMsg(Utils.metodoBackEncoder(Acoes.ADD_PONTOS_A));
    }
    
    public static void pausarJogo() {
        Client.enviarMsg(Utils.metodoBackEncoder(Acoes.PAUSE));
    }
    
    public static void atualizarJogo(String acao, String valor) {
        System.out.println("aoa" + acao);
        if (valor.indexOf(";") > -1) {
            System.out.println("iaiaiaiaiaiaiiao");
            String[] splittedValue = valor.split(";");
            if (acao.equals(Acoes.INICIAR_JOGO.name())) {
                JogoDto j = new JogoDto();
                j.setTipoJogo(splittedValue[0]);
                j.setTempoEstimado(Utils.tempoConverter(splittedValue[1]));
                j.setTimeA(splittedValue[2]);
                j.setTimeB(splittedValue[3]);
                j.attach(Client.jogo.getObservers().get(0));
                Client.jogo = j;
                Client.jogo.setJogando(true);
            }
            
        } else {
            if (acao.equals(Acoes.PAUSE.name())) {
                Client.jogo.setPausado(true);
            } else if (acao.equals(Acoes.INICIAR_JOGO.name())) {
                Client.jogo.setJogando(true);
            }
        }
        System.out.println("ACAO : " + acao + "   ------ valor : " + valor);
    }
}
