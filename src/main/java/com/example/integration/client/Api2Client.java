package com.example.integration.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class Api2Client {

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "api2", fallbackMethod = "fallback")
    @Retry(name = "api2")
    public List<Map<String, Object>> fetchUsers() {

        return restTemplate.exchange(
                "http://localhost:8080/mock-api",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        ).getBody();
    }

    public List<Map<String, Object>> fallback(Throwable ex) {
        System.out.println("API2 fallback: " + ex.getMessage());
        return List.of();
    }
}
