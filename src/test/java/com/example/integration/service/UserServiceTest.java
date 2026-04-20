package com.example.integration.service;

import com.example.integration.client.Api1Client;
import com.example.integration.client.Api2Client;
import com.example.integration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private Api1Client api1;

    @Mock
    private Api2Client api2;

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    void shouldSyncAndReturnUsers() {

        when(api1.fetchUsers()).thenReturn(List.of(
                Map.of("id", "1", "name", "John", "email", "john@test.com")
        ));

        when(api2.fetchUsers()).thenReturn(List.of(
                Map.of("uuid", "2", "fullName", "Maria", "mail", "maria@test.com", "active", true)
        ));

        when(repository.saveAll(anyList())).thenAnswer(i -> i.getArgument(0));

        var result = service.sync();

        assertEquals(2, result.size());
        verify(repository, times(1)).saveAll(anyList());
    }
}
