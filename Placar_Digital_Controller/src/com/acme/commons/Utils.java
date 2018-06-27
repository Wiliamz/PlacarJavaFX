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
import java.util.HashMap;
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
//        System.out.println("MD5: " + md5);
        return md5;
    }

    public static Usuario fazerLogin(String login, String senha) throws NoSuchAlgorithmException {
        try {
            File file = new File("src/com/acme/xml/usuarios.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(UsuarioWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            UsuarioWrapper uw = (UsuarioWrapper) jaxbUnmarshaller.unmarshal(file);
            for (Usuario u : uw.getUsers()) {
                if (u.getLogin().equals(login) && u.getPassword().equals(senha)) {
//                    System.out.println("u.getPassword() " + u.getPassword() + " senha " + senha);
                    return u;
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao abrir o arquivo :(", "Erro ao abrir", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static int tempoConverter(String tempo) {
        String[] splittedTime = tempo.split("-");
        return (Integer.parseInt(splittedTime[0]) * 60) + Integer.parseInt(splittedTime[1]);
    }

    public static String formatSecondsToSTring(int seconds) {
        String valor = "";
        int minutos = seconds / 60;
        int segundos = seconds % 60;
        if (minutos > 0) {
            valor = (minutos > 9 ? String.valueOf(minutos) : "0" + minutos) + ":" + (segundos > 10 ? String.valueOf(segundos) : "0" + segundos);
        } else {
            valor = "00:" + segundos;
        }
        return valor;
    }

    public static String[] metodoFrontDecoder(String acaoEncoded) {
        String[] splitted = acaoEncoded.split(":");
        return splitted;
    }

    public static String metodoBackEncoder(Acoes acao) {
        return acao.name() + "\n";
    }

    public static String metodoBackEncoder(String acao) {
        return acao + "\n";
    }
}
