package com.admSystem.financialSystem.controller;

import com.admSystem.financialSystem.data.UserEntity;
import com.admSystem.financialSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserId(@PathVariable Long id) {
        UserEntity userId = userService.getUserId(id);

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        var newUsew = userService.createUser(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user) {
        boolean valid = userService.validateLogin(user.getUserName(), user.getPassword());

        if (valid) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos!");
        }
    }

}
