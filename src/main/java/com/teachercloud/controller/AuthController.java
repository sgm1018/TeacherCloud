package com.teachercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.teachercloud.Dto.auth.UserLoginDto;
import com.teachercloud.Dto.auth.UserRegisterDto;
import com.teachercloud.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;



    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("userLoginDto", new UserLoginDto());
        return "auth/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto) {
        System.out.println(userLoginDto.getEmail());
        System.out.println(userLoginDto.getPassword());
        return "redirect:/user/profile";
        
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
