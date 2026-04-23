package com.hospital.system.Security;

import com.hospital.system.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private String jwtSecret="fadfihahefhqhery83494y9384h3092hhfa89e9893h92nio23";
    public SecretKey getJwtSecretKey() {
    return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
    public String getToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(getJwtSecretKey())
                .compact();
    }
}
