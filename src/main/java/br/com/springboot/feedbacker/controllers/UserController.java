package br.com.springboot.feedbacker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.feedbacker.models.User;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/users")
public class UserController {


    @PostMapping("/")
    public User RegisterUser(@RequestBody User newUser){
        return newUser;
    }

    @GetMapping("/{id}")
    public User GetUser(@PathParam("id") Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public User DeleteUser(@PathParam("id") Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public User UpdateUser(@PathVariable Long id, @RequestBody User user) {        
        return null;
    }
}
