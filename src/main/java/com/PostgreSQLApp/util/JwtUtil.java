package com.PostgreSQLApp.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private static final String SECRET_KEY = "your-secret-key"; // Keep this secret and secure

    // 🔹 Generate JWT token (1 minute validity)
    public static String generateToken(String email) {
        long expirationTimeInMs = 60 * 1000; // 1 minute
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMs))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        logger.info("Generated token for email: {}", email);
        return token;
    }

    // 🔹 Validate JWT token
    public static boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            boolean valid = claims.getExpiration().after(new Date());
            if (valid) {
                logger.debug("Token validated successfully for subject: {}", claims.getSubject());
            } else {
                logger.warn("Token expired for subject: {}", claims.getSubject());
            }
            return valid;
        } catch (ExpiredJwtException e) {
            logger.warn("JWT token expired at {}", e.getClaims().getExpiration());
            return false;
        } catch (Exception e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
            return false;
        }
    }

    // 🔹 Extract email from token
    public static String extractEmail(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            logger.debug("Extracted email from token: {}", email);
            return email;
        } catch (Exception e) {
            logger.error("Failed to extract email from token: {}", e.getMessage());
            return null;
        }
    }
}
