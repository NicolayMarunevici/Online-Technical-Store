package com.auth.store.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

  public JwtTokenProvider(@Value("${app.jwt-secret}") String jwtSecret,
                          @Value("${app-jwt-expiration-milliseconds}") long jwtExpirationDate) {
    this.jwtSecret = jwtSecret;
    this.jwtExpirationDate = jwtExpirationDate;
  }

  private final String jwtSecret;
  private final long jwtExpirationDate;

  //generate JWT token
  public String generateToken(Authentication authentication) {
    String username = authentication.getName();

    Date currentDate = new Date();
    Date expirationDate = new Date(currentDate.getTime() + jwtExpirationDate);

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(expirationDate)
        .signWith(key())
        .compact();
  }

  private Key key() { // decode secret key from aplication-properties
    return Keys.hmacShaKeyFor(
        Decoders.BASE64.decode(jwtSecret)
    );
  }

  // get username from JWT token
  public String getUsername(String token) {
    Claims claims = Jwts.parserBuilder() // parse JWT token on different parts
        .setSigningKey(key()) // secret key
        .build()
        .parseClaimsJws(token)
        .getBody();
    return claims.getSubject(); // get username
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder()
          .setSigningKey(key())
          .build()
          .parse(token);
      return true;
    } catch (MalformedJwtException exception) {
      throw new UserNotFoundException("Invalid JWT token", HttpStatus.BAD_REQUEST);
    } catch (ExpiredJwtException exception) {
      throw new UserNotFoundException("Expired JWT token", HttpStatus.BAD_REQUEST);
    } catch (UnsupportedJwtException exception) {
      throw new UserNotFoundException("Unsupported JWT token", HttpStatus.BAD_REQUEST);
    } catch (IllegalArgumentException e) {
      throw new UserNotFoundException("JWT claims string are empty", HttpStatus.BAD_REQUEST);
    }
  }
}
