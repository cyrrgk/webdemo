package chapter6;

import java.security.*;

public class Encrypter {
	
	public static String md5Encrypt(String s) throws Exception{
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
		return base64Encoder.encode(md5.digest(s.getBytes("utf-8")));
	}

}
