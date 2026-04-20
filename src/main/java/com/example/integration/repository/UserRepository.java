package com.example.integration.repository;

import com.example.integration.enums.Status;
import com.example.integration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByStatus(Status status);
}
