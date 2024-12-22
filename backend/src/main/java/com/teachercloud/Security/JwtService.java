package com.teachercloud.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.teachercloud.model.User;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {
    // Inyectamos los valores del application.properties
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("roles", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // ClaimResolver es una funcion que se pasa a traves de
    // Claims::FuncionQueMeDevuelve el claim que quiero
    // <Fuction<Claims, T> claimsResolver> es una funcion que recibe un Claims y
    // devuelve un T
    // Usar Claims:: es una forma de pasar funciones como argumento a las funciones,
    // ya que son funciones definidas en la clase Claims
    // y no la funcion a la que entra como argumento, entiende que tienen que llamar
    // a esa funcion.
    // posteriormete el .apply llama a la funcion que se paso como argumento
    // En conclusion, es una forma de hacer un metodo generico para obtener
    // cualquier tipo de CLAIM.
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Claims validateToken(String token) {
        try {
            // token valido
            return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // token invalido
            throw new RuntimeException("Token inválido o expirado.");

        }
    }

    public Boolean checkRol(String token, String role) {
        final Claims claims = getAllClaimsFromToken(token);
        final String roles = claims.get("roles", String.class);
        return roles != null && roles.contains(role);
    }

    public JwtAuthenticationToken getAuthentication(Claims claims) {
        return new JwtAuthenticationToken(claims.getSubject(), claims.get("role"));

    }
}