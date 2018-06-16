/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.commons;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Gabriel Cardoso
 */
public class Utils {

    public static String gerarMd5(String string) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(string.getBytes(), 0, string.length());
        System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(16));
        return new BigInteger(1, m.digest()).toString(16);
    }
}
