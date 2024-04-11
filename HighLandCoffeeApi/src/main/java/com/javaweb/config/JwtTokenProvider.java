package com.javaweb.config;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenProvider {
	
	private SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
	
	// public String generateAccessToken(Authentication auth) {

	// 	String jwt=Jwts.builder()
	// 			.setIssuedAt(new Date())
	// 			.setExpiration(new Date(new Date().getTime()+604800000))
	// 			.claim("username",auth.getName())
	// 			.signWith(key)
	// 			.compact();
		
	// 	return jwt;	
	// }
	public String generateAccessToken(Authentication auth) {
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		String authoritiesString = populateAuthorities(authorities);

		String jwt = Jwts.builder()
    .setIssuedAt(new Date())
    .setExpiration(new Date(new Date().getTime() + 604800000))
    .claim("username", auth.getName())
    .claim("authorities",populateAuthorities(auth.getAuthorities()))
    .signWith(key)
    .compact();
		return jwt;
	}

	// public String generateRefreshToken(Authentication auth) {

	// 	String jwt=Jwts.builder()
	// 			.setIssuedAt(new Date())
	// 			.setExpiration(new Date(new Date().getTime()+259200000))
	// 			.claim("username",auth.getName())
	// 			.signWith(key)
	// 			.compact();
		
	// 	return jwt;	
	// }
	public String generateRefreshToken(Authentication auth) {
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		String authoritiesString = populateAuthorities(authorities);

		String jwt = Jwts.builder()
    .setIssuedAt(new Date())
    .setExpiration(new Date(new Date().getTime() + 259200000))
    .claim("username", auth.getName())
    .claim("authorities",populateAuthorities(auth.getAuthorities()))
    .signWith(key)
    .compact();

		return jwt;
	}

	public String getUsernameFromJwtToken(String jwt) {
		jwt = jwt.substring(7);
	
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		String email = String.valueOf(claims.get("username"));
		System.err.println("username get by jwt " + email);
		return email;
	}
	
	public String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set <String> auths=new HashSet<>();
		
		for(GrantedAuthority authority:collection) {
			auths.add(authority.getAuthority());
		}
		return String.join(",",auths);
	}

}
