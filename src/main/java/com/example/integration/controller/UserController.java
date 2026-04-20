package com.example.integration.controller;

import com.example.integration.model.User;
import com.example.integration.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/sync")
    public List<User> sync() {
        return service.sync();
    }

    @   GetMapping
    public List<User> get(@RequestParam(required = false) String status) {
        return service.findAll(status);
    }
}
