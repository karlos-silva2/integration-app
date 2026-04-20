package com.example.integration.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class Api1Client {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Map<String, Object>> fetchUsers() {
        return restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/users",
                List.class
        );
    }
}
