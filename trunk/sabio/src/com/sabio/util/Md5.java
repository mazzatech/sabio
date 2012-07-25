package com.sabio.util;


public class Md5 {

	public String encrypt(String enc) {
		String RESULTADO = "";
		for (int i = 0; i < enc.length(); i++) {
			RESULTADO += getNUMBER();
			RESULTADO += getKEY();
			RESULTADO += enc.substring(i, i + 1);
		}
		return RESULTADO;
	}

	public String getKEY() {
		return new Character((char) (Math.random() * 23 + 97)).toString();
	}

	public String getNUMBER() {
		return String.valueOf(Math.round(Math.random() * 1000 % 999));
	}

	public static String encryptMD5(String texto) {
		String sign = texto;

		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(sign.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10)
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				else
					hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
			sign = hexString.toString();
		} catch (Exception nsae) {
			nsae.printStackTrace();
		}
		return sign;
	}

}
