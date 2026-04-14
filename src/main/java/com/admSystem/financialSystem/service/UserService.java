package com.admSystem.financialSystem.service;

import com.admSystem.financialSystem.data.RoleEntity;
import com.admSystem.financialSystem.data.RoleRepository;
import com.admSystem.financialSystem.data.UserEntity;
import com.admSystem.financialSystem.data.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /*metodo para criar o usuário*/
    public UserEntity createUser(UserEntity user) {
        user.setId(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity roleUser = roleRepository.findByRoleName("USER").orElse(null);
        user.getRoles().add(roleUser);
        return userRepository.save(user);
    }
    
    /*metodo para validar o usuário*/
    public boolean validateLogin(String email, String password) {
        Optional<UserEntity> userOpt = userRepository.findByUserName(email);

        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            return passwordEncoder.matches(password, user.getPassword());
        }

        return false;
    }

    /*metodo get para identificação do user dentro do banco de dados*/
    public UserEntity getUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
