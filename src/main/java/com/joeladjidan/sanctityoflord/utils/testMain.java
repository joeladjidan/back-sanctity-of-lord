package com.joeladjidan.sanctityoflord.utils;

import com.joeladjidan.sanctityoflord.model.auth.ExtendedUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class testMain {

    @Autowired
    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		JwtUtil jwtUtil = new JwtUtil();

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority("ADMIN"));

		ExtendedUser userDetails = new ExtendedUser("anagkazo@gmail.com", "Anagkazo2022*", 1, authorities);
		jwtUtil.generateToken(userDetails);

	}
}
