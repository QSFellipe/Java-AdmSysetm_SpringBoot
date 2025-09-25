package com.admSystem.financialSystem.service;

import com.admSystem.financialSystem.data.RoleEntity;
import com.admSystem.financialSystem.data.RoleRepository;
import com.admSystem.financialSystem.data.UserEntity;
import com.admSystem.financialSystem.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /*metodo para criar o usuário*/
    public UserEntity createUser(UserEntity user) {
        user.setId(null);
        RoleEntity roleUser = roleRepository.findByRoleName("USER").orElse(null);
        
        user.getRoles().add(roleUser);
        return userRepository.save(user);
    }

    /*metodo get para identificação do user dentro do sistema*/
    public UserEntity getUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
