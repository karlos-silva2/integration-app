package com.example.integration.model;

import com.example.integration.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String source;
}