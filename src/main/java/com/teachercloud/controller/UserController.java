package com.teachercloud.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teachercloud.Dto.user.CrearUsuarioDto;
import com.teachercloud.model.User;
import com.teachercloud.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(Model model) throws ResponseStatusException {
        var datos = userService.GetAll();
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erorr: " + datos.msg());
        }
        model.addAttribute(datos.value());
        return ResponseEntity.ok(datos.value());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@RequestParam Long id) throws ResponseStatusException {
        var datos = userService.GetById(id);
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Errpr:" + datos.msg());
        }
        return ResponseEntity.ok(datos.value());
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody CrearUsuarioDto user) throws ResponseStatusException {
        System.out.println(user);
        var datos = userService.add(user.toEntidad());
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + datos.msg());
        }
        return ResponseEntity.ok(datos.value());
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<User> updateUser(@RequestParam String id, @ModelAttribute User user) throws ResponseStatusException {
        var datos = userService.update(user);
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + datos.msg());
        }

        return ResponseEntity.ok(datos.value()); 
    }

    @DeleteMapping("/delete/{id}") 
    public ResponseEntity<User> deleteUser(@RequestParam Long id) throws ResponseStatusException {
        var datos = userService.remove(id);
        if (datos.result() != 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + datos.msg());
        }
        return ResponseEntity.ok(datos.value());
    }
    
    
    


}
