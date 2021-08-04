package com.bcp.reto.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcp.reto.security.JwtGenerator;

@Controller
@RequestMapping("/token")
public class TokenController {
	
	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	@GetMapping
	public ResponseEntity<?> generate() {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("token", jwtGenerator.generate());
		return new ResponseEntity<HashMap<String, String>>(hash, HttpStatus.OK);
	}
}
