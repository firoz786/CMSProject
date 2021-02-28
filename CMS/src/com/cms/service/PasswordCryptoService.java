/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Rishabh Gupta
 */
public class PasswordCryptoService {

    private String key;
    private String input;
    private String output;

    /**
     * @param password
     * @return String
     */
    public String getEncryptedPassword(String password) {
        input = password;
        key();
        performCMSEncryption();
        performMD5();
        return output;
    }

    private void key() {
        key = Integer.toString(input.hashCode());

    }

    private void performCMSEncryption() {
        StringBuffer buffer = new StringBuffer(key);
        for (int i = 0; i < input.length(); i++) {
            buffer.append((int) input.charAt(i));
        }
        buffer.append("CMS");
        input = buffer.toString();
    }

    private void performMD5() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = input.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            output = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }


}
