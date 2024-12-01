package com.teachercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teachercloud.model.User;
import com.teachercloud.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) throws ResponseStatusException {
        var datos = userService.GetAll();
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erorr: " + datos.msg());
        }
        model.addAttribute(datos.value());
        return "users/list";
    }


    @GetMapping("/{id}")
    public String getUserById(@RequestParam("id") Long id, Model model) throws ResponseStatusException {
        var datos = userService.GetById(id);
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Errpr:" + datos.msg());
        }
        model.addAttribute(datos.value());
        return "users/detail";
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user, Model model) throws ResponseStatusException {
        var datos = userService.add(user);
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + datos.msg());
        }
        return "redirect:/user";
    }

    @PutMapping("edit/{id}")
    public String updateUser(@PathVariable String id, @ModelAttribute User user) throws ResponseStatusException {
        var datos = userService.update(user);
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + datos.msg());
        }

        return "redirect:/user"; 
    }

    @DeleteMapping("/delete/{id}") 
    public String deleteUser(@PathVariable Long id) throws ResponseStatusException {
        var datos = userService.remove(id);
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + datos.msg());
        }
        return "redirect:/user";
    }
    
    
    


}
