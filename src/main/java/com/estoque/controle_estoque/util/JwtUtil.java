package com.estoque.controle_estoque.util;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;



@Component
public class JwtUtil {
    private String chave;
    private static Key secretKey;

    @Value("${jwt.secret}")
    public void setChave(String chave){
        this.chave = chave;
        JwtUtil.secretKey = Keys.hmacShaKeyFor(this.chave.getBytes());
    }

    public static String GeraToken(String username,String email){
        int expiresIn = 1000*60*60;
        return Jwts.builder()
            .setSubject(username)
            .claim("email", email)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+expiresIn))
            .signWith(JwtUtil.secretKey, SignatureAlgorithm.HS256)
            .compact();
    }

    public static Jws<Claims> validateToken(String token){
        return Jwts.parserBuilder()
            .setSigningKey(JwtUtil.secretKey)
            .build()
            .parseClaimsJws(token);
    }

    public static String getTokenUser(String token){
        return validateToken(token).getBody().getSubject();
    }

    public static String getTokenEmail(String token){
        return validateToken(token).getBody().get("email",String.class);
    }
}
