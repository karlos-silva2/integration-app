package com.example.integration.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mock-api")
public class MockController {

    @GetMapping
    public List<Map<String, Object>> mock() {
        return List.of(
                Map.of(
                        "uuid", "1",
                        "fullName", "Mock User 1",
                        "mail", "mock1@email.com",
                        "active", true
                ),
                Map.of(
                        "uuid", "2",
                        "fullName", "Mock User 2",
                        "mail", "mock2@email.com",
                        "active", false
                )
        );
    }
}
