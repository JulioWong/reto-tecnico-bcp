package com.bcp.reto.security;

import org.springframework.stereotype.Component;

import com.bcp.reto.constants.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	public String generate() {
		Claims claims = Jwts.claims()
				.setSubject("Reto técnico");
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Constants.YOUR_SECRET)
				.compact();
	}
}
