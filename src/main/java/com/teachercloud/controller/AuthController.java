package com.teachercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.teachercloud.Dto.auth.UserLoginDto;
import com.teachercloud.Dto.auth.UserRegisterDto;
import com.teachercloud.Security.JwtAuthenticationToken;
import com.teachercloud.Security.JwtService;
import com.teachercloud.Security.PasswordService;
import com.teachercloud.model.User;
import com.teachercloud.service.UserService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordService passwordService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        var datos = userService.findByEmail(userLoginDto.getEmail());
        if (datos.result()  != 0) {
            return ResponseEntity.badRequest().body(datos.msg());
        }

        if (!passwordService.decodePassword(userLoginDto.getPassword(), datos.value().getPassword())) {
            return ResponseEntity.badRequest().body("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(datos.value());
        return ResponseEntity.ok(token);   
    }

    @GetMapping("/register")
    public String registerForm() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterDto userRegisterDto) {
        
        return "redirect:/login";
    }
    
    
    



}
