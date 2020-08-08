package com.udemy.controllers;

import com.udemy.entities.User;
import com.udemy.services.UserService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value ="/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User u  = userService.findById(id);
        return ResponseEntity.ok(u);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        user = userService.save(user);
        return ResponseEntity.status(201).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<User> update (@RequestBody User user){
            User u = userService.update(user);
            return ResponseEntity.ok(u);
    }


}
