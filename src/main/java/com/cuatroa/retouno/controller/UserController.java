/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.retouno.controller;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FabianMendoza
 */
/**
 * Se crean las anotaciones de servicios, endpoint, y CrossOrigin para evitar
 * restriciones
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    /**
     * Autowired para que Springboot pueda instanciar la clase cuando lo requiera
     */
    @Autowired
    private UserService userService;
    /**
     * GetMapping para recuperación de usuarios
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
     * PostMapping para el método "registrar" para la creación de un nuevo usuario mediante método POST
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    /**
     * GetMapping para el método "autenticarUsuario" para validar si los datos del usuario,
     * email y la contraseña existen mediante un método GET
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    /**
     * GetMapping para el método "existeEmail" para validar si el email existe, 
     * el cual es insertado en la URL mediante un método GET
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }
}

