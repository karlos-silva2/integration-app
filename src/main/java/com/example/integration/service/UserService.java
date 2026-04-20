package com.example.integration.service;

import com.example.integration.client.Api1Client;
import com.example.integration.client.Api2Client;
import com.example.integration.enums.Status;
import com.example.integration.model.User;
import com.example.integration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final Api1Client api1;
    private final Api2Client api2;
    private final UserRepository repo;

    public UserService(Api1Client api1, Api2Client api2, UserRepository repo) {
        this.api1 = api1;
        this.api2 = api2;
        this.repo = repo;
    }

    public List<User> sync() {

        List<User> users = new ArrayList<>();

        api1.fetchUsers().forEach(u -> {
            users.add(User.builder()
                    .id(String.valueOf(u.get("id")))
                    .name((String) u.get("name"))
                    .email((String) u.get("email"))
                    .status(Status.ACTIVE)
                    .source("API1")
                    .build());
        });

        api2.fetchUsers().forEach(u -> {
            users.add(User.builder()
                    .id((String) u.get("uuid"))
                    .name((String) u.get("fullName"))
                    .email((String) u.get("mail"))
                    .status((Boolean) u.get("active") ? Status.ACTIVE : Status.INACTIVE)
                    .source("API2")
                    .build());
        });

        return repo.saveAll(users);
    }

    public List<User> findAll(String status) {
        if (status != null) {
            return repo.findByStatus(Status.valueOf(status));
        }
        return repo.findAll();
    }
}
