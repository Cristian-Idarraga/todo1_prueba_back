package com.todo1.prueba_tecnica.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	private static final String KEY = "CnJ#UR5%r7d&=rn%";

	public String gnerateToken(UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS384, KEY).compact();
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
		return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
	}
	
	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	public boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}
	
	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}
}
