package com.teachercloud.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PasswordService {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Encriptar la contraseña
    public String codePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // Verificar la contraseña
    public boolean decodePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
