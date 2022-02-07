package pe.com.synopsis.imgrabber.dao.mapper;

import java.util.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class adsad {

	public static void main(String[] args) {

		//password
		String originalInput = "int3rb4nk";// Sc0t14b4nk//int3rb4nk
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		System.out.println(encodedString);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode(originalInput));

		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		// U2MwdDE0YjRuaw==
		System.out.println(decodedString);

	}

}
