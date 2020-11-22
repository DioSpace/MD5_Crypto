package my.com;

import java.util.LinkedHashMap;

public class Main {

    private static String plaintext = "com.youxiang.soyoungapp1591965539332";
    private static String ciphertext = "";

    public static void main(String[] args) {
        //c8aecc6dc33b9651e81b20b22806d7d1
        ciphertext = MD5.getMD5(plaintext, 32);
        System.out.println("result:\n" + ciphertext);
        
    }
}
