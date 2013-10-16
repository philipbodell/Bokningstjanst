/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

/**
 *
 * @author anon
 */
public final class Encrypter {
    
    private Encrypter() {
    }
    
    /*
     * Using Md5 encryption. Very unsafe compared to other solutions but it'll
     * do for now. We have no decrypt function since that makes it possible 
     * for people to guess what algorithm we are using to encrypt our messages with.
     * 
     * Md5 is very fast on modern machines so when we get an input string to compare with
     * the stored encrypted password we only encrypt the input string and then compare if they
     * are equal.
     */
    
    /** Method that encrypts the input string.
     * 
     * @param md5 the String to encrypt
     * @return the encrypted string.
     */
    
    public static final String enCrypt(String md5) {
    try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {}
    return null;
    }
    
}
