package com.base.admin.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

//https://github.com/hantsy/spring-webmvc-jwt-sample/blob/master/src/main/java/com/example/demo/security/jwt/JwtTokenProvider.java
@Component
public class JwtUtils {

    @Value("${token.signing.key}")
    private String jwtSecret;

    @Value("${token.signing.expiration}")
    private int jwtExpirationMs;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateJwtToken(Authentication authentication) {

        JwtUserDetails userPrincipal = (JwtUserDetails) authentication.getPrincipal();

        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        Instant now = Instant.now();
        Instant expiration = now.plusSeconds(24 * 3600); // expires in 1 hour * 24
        Date expDate = Date.from(expiration);

        return Jwts.builder()
                .subject((userPrincipal.getUsername()))
                .issuedAt(Date.from(now))
                .expiration(expDate)
                .signWith(secretKey)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserNameFromJwtToken(String token) {
//    return Jwts.parserBuilder().setSigningKey(key()).build()
//               .parseClaimsJws(token).getBody().getSubject();

//    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

        JwtParser parser = Jwts.parser()
                .verifyWith(secretKey)
                .build();

        Claims claims = parser.parseSignedClaims(token).getPayload();

        String extractedSubject = claims.getSubject();

//
//// Reading Reserved Claims
//    System.out.println("Subject: " + claims.get("sub"));
//    System.out.println("Expiration: " + claims.get("exp"));
//
//// Reading Custom Claims
//    System.out.println("Role: " + claims.get("Role"));
//    System.out.println("Department: " + claims.get("Department"));

        return extractedSubject;

    }

    public boolean validateJwtToken(String authToken) {
        try {
//      SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
            JwtParser parser = Jwts.parser().verifyWith(secretKey).build();
            Jws<Claims> claims = parser.parseSignedClaims(authToken);
            return true;
        } catch (MalformedJwtException e) { //TODO handle custom exception
//      logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
//      logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
//      logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
//      logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
