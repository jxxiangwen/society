package cn.edu.shu.society.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestGenerator {
	private static String generateHash(String digest, String srcMessage) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
        md.update(srcMessage.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex= Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	
    	return hexString.toString();
	}

	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static String generateSHA256(String src) {
		return generateHash("SHA-256", src);
	}

    public static void main(String[] args) {
//        String  a64CookieStr = "u_"	+ "10"+ ":"
//                + MessageDigestGenerator.generateSHA256("123456");
//
//        a64CookieStr = "Basic " + Base64.encode(a64CookieStr);
        String sha256 = MessageDigestGenerator.generateSHA256("111111");
        String base64 = Base64.encode(sha256);
        System.out.println(sha256);
        System.out.println(base64);
    }
}
