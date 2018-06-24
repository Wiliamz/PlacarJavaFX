/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.commons;

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
}
