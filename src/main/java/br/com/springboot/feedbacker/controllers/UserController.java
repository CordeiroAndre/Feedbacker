package br.com.springboot.feedbacker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.springboot.feedbacker.models.User;
import br.com.springboot.feedbacker.models.DTOs.UserDTO;
import br.com.springboot.feedbacker.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> RegisterUser(@RequestBody UserDTO userToSave){
        User newUser = new User();
        newUser.setEmail(userToSave.email());
        userService.createUser(newUser);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> GetUser(@PathVariable("id") Long id) {
        try {
            User foundUser = userService.findUserById(id);
            return new ResponseEntity<User>(foundUser, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> DeleteUser(@PathVariable("id") Long id) {
            try {
            User deletedUser = userService.deleteUserById(id);
            return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
