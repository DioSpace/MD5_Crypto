package my.com;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getMD5(String plainText, int length) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//获取MD5实例
            byte[] byteArr = plainText.getBytes();//获取字符串的byte数组，也就是获取字符串的二进制形式
            md.update(byteArr);//此处传入要加密的byte数组
            byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值

            String result = byteArrToHexString(digest);
            return result.substring(0, length);//从下标0开始，length目的是截取多少长度的值
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    //将byte 数组 转换成16进制字符串
    private static String byteArrToHexString(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        for (int offset = 0; offset < digest.length; offset++) {
            int tmp = digest[offset];//根据下标 取byte 并转化成 int型
            if (tmp < 0) {//如果byte 对应的int为负,为了能转成16进制字符串,就加上一个模(FF,256)
                tmp += 256;
            }
            if (tmp < 16) {//如果byte 只有低4位有值,转换成的16进制字符串只有一个，为了得到两个字符串可以在低位补0
                sb.append(0);
            }
            sb.append(Integer.toHexString(tmp));//通过Integer.toHexString方法把值变为16进制
        }
        return sb.toString();//从下标0开始，length目的是截取多少长度的值
    }
}
