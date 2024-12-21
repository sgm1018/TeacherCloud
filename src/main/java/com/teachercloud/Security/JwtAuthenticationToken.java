package com.teachercloud.Security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String username; // Nombre de usuario extraído del token
    private final Object role; // Rol extraído del token

    public JwtAuthenticationToken(String username, Object role) {
        super(Collections.emptyList()); // No necesitamos GrantedAuthorities en este ejemplo
        this.username = username;
        this.role = role;
        setAuthenticated(true); // Marcamos este token como autenticado
    }

    @Override
    public Object getCredentials() {
        return null; // No hay credenciales adicionales para JWT
    }

    @Override
    public Object getPrincipal() {
        return username; // Devuelve el usuario autenticado
    }

    public Object getRole() {
        return role; // Devuelve el rol asociado al token
    }
}
