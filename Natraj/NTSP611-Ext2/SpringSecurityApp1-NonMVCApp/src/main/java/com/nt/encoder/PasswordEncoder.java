package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder =
				                         new BCryptPasswordEncoder();
		String hashedPwd1 = passwordEncoder.encode("rani");
		String hashedPwd3 = passwordEncoder.encode("naresh");
		String hashedPwd2 = passwordEncoder.encode("hyd");
		String hashedPwd4 = passwordEncoder.encode("begum");
		System.out.println(hashedPwd1+"            "+hashedPwd2+"  "+hashedPwd3+"  "+hashedPwd4);
		
	}

}
