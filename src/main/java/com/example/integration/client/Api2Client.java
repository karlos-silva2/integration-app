package com.example.integration.client;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Api2Client {

    public List<Map<String, Object>> fetchUsers() {
        return List.of(
                Map.of("uuid", "100", "fullName", "Mock User", "mail", "mock@email.com", "active", true)
        );
    }
}
