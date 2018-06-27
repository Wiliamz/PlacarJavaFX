/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.commons;

import com.acme.enums.Acoes;
import com.acme.model.Usuario;
import com.acme.model.UsuarioWrapper;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Gabriel Cardoso
 */
public class Utils {

    public static String gerarMd5(String string) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(string.getBytes(), 0, string.length());
        String md5 = new BigInteger(1, m.digest()).toString(16);
        System.out.println("MD5: " + md5);
        return md5;
    }

    public static int tempoConverter(String tempo) {
        String[] splittedTime = tempo.split("-");
        return (Integer.parseInt(splittedTime[0]) * 60) + Integer.parseInt(splittedTime[1]);

    }

    public static void callServerMethod(String obj) {
        if (obj.indexOf(";") > -1) {
            String[] splitted = obj.split(";");
            System.out.println("splitted[0].equals(Acoes.PRORROGACAO.name())" + splitted[0].equals(Acoes.PRORROGACAO.name()));
            if (splitted[0].equals(Acoes.INICIAR_JOGO.name())) {
                Server.startGame(splitted[1], splitted[2], splitted[3], splitted[4]);
            } else if (splitted[0].equals(Acoes.PRORROGACAO.name())) {
                Server.addProrrogacao(Integer.parseInt(splitted[1]));
            }
            System.out.println("OBJECTO" + obj);
        } else {
            if (obj.equals(Acoes.ADD_PONTOS_A.name())) {
                Server.addPontosA();
            } else if (obj.equals(Acoes.ADD_PONTOS_B.name())) {
                Server.addPontosB();
            } else if (obj.equals(Acoes.REMOVE_PONTOS_A.name())) {
                Server.removePontosA();
            } else if (obj.equals(Acoes.REMOVE_PONTOS_B.name())) {
                Server.removePontosB();
            } else if (obj.equals(Acoes.PLAY.name())) {
                Server.continueGame();
            } else if (obj.equals(Acoes.PAUSE.name())) {
                Server.pauseGame();
            } else if (obj.equals(Acoes.STOP.name())) {
                Server.endGame();
            }
        }
    }
}
