package com.hj.entity.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {


    public static String getMd5(String pw) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(pw.getBytes());
            StringBuffer msg = new StringBuffer();
            for (byte b : digest) {
                msg.append(String.format("%02x", b));
            }
            return msg.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
