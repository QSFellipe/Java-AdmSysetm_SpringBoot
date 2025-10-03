package com.admSystem.financialSystem.service;

import com.admSystem.financialSystem.data.RoleEntity;
import com.admSystem.financialSystem.data.RoleRepository;
import com.admSystem.financialSystem.data.UserEntity;
import com.admSystem.financialSystem.data.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_ShouldEncodePasswordWithBCrypt() {
        String rawPassword = "senha123";
        String encodedPassword = "$2a$10$xyz123encodedPasswordHash";

        UserEntity user = new UserEntity();
        user.setId(999L);
        user.setUserName("usuarioTeste");
        user.setEmail("teste@email.com");
        user.setPassword(rawPassword);
        user.setRoles(new HashSet<>());

        RoleEntity roleUser = new RoleEntity();
        roleUser.setId(1L);
        roleUser.setRoleName("USER");

        UserEntity savedUser = new UserEntity();
        savedUser.setId(1L);
        savedUser.setUserName("usuarioTeste");
        savedUser.setEmail("teste@email.com");
        savedUser.setPassword(encodedPassword);
        savedUser.setRoles(new HashSet<>());
        savedUser.getRoles().add(roleUser);

        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);
        when(roleRepository.findByRoleName("USER")).thenReturn(Optional.of(roleUser));
        when(userRepository.save(any(UserEntity.class))).thenReturn(savedUser);

        UserEntity result = userService.createUser(user);

        assertNotNull(result);
        assertNotEquals(rawPassword, result.getPassword());
        assertEquals(encodedPassword, result.getPassword());
        assertTrue(result.getPassword().startsWith("$2a$"));

        verify(passwordEncoder, times(1)).encode(rawPassword);
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

}
