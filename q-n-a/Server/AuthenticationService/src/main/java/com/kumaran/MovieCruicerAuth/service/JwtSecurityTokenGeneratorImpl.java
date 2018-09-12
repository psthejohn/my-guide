package com.kumaran.MovieCruicerAuth.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kumaran.MovieCruicerAuth.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	@Override
	public Map<String, String> generateToken(User user) {
		String jwtToken = "";
		
		jwtToken= Jwts.builder().setSubject(user.getUserId()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		Map<String, String> map = new HashMap<>();
		map.put("token", jwtToken);
		System.out.println("jwt token for user "+user.getUserId()+" is "+jwtToken);
		map.put("message", "user successfully logged in");
		return map;
	}

}
