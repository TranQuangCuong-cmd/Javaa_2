package bo;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class mahoa {
	public static String ecrypt(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String enrtext; MessageDigest msd=MessageDigest.getInstance("MD5"); 
		byte[] srctextbyte=text.getBytes("UTF-8"); byte[] enrtextbyte=msd.digest(srctextbyte);
		BigInteger big = new BigInteger(1, enrtextbyte); enrtext=big.toString(16); return enrtext;
		}
	public static void main(String[] args) {
		try {
			System.out.print(mahoa.ecrypt("haha"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}