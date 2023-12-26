package com.WeWork.UserService.config;

import com.WeWork.UserService.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
   @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration-in-ms}")
    private long jwtExpirationInMs;
    private final Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    public static final String SECRET = "5367576456546766B59703373367639792F423F4528482B4D6251655468576D5A71347437";


    public String generateToken(String userName){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,userName);
    }


    public String createToken(Map<String,Object> claims, String username){

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationInMs))
                .signWith(getSignKey(),SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public  boolean  validateToken(final String token){

//            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token);
            // Log or print the claims for debugging
            Claims claims = claimsJws.getBody();
            System.out.println("Token Claims: " + claims);
            return true;
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return false;
        }
    }



}
