package com.my;

public class Main {

    private static String plaintext = "thisisatest";
    private static String ciphertext = "";

    public static void main(String[] args) {
        ciphertext = MD5.getMD5(plaintext, 32);
        System.out.println("result:\n" + ciphertext);
    }
}
