package com.superDemo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    public static String base64encoder(String s){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(s.getBytes());
    }

    public static String base64decoder(String s){
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            return new String(base64Decoder.decodeBuffer(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5(String s){
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] b = md.digest(s.getBytes());
            BASE64Encoder base64 = new BASE64Encoder();
            return base64.encode(b);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
