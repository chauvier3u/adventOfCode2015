package Day4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Principale
{

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String input = "iwrupvqb";
		boolean vrai = true;
		int i = 0;

		MessageDigest md = MessageDigest.getInstance("MD5");
		while (vrai)
		{

			String input2 = input + i;
			byte[] byteChaine = input2.getBytes("UTF-8");
			byte[] hash = md.digest(byteChaine);

			String code = DatatypeConverter.printHexBinary(hash);

			if (code.charAt(0) == '0' && code.charAt(1) == '0' && code.charAt(2) == '0' && code.charAt(3) == '0'
					&& code.charAt(4) == '0' && code.charAt(5) == '0')
			{
				vrai = false;
			}
			i++;
		}
		System.out.println(i - 1);

	}
}