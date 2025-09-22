package com.admSystem.financialSystem.service;

import com.admSystem.financialSystem.data.UserEntity;
import com.admSystem.financialSystem.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserRepository userRepo;
    
     /*metodo para criar o usuário*/
    public UserEntity createUser(UserEntity user){
        user.setId(null);
        userRepo.save(user);
        return user;
    }
    
    /*metodo get para identificação do user dentro do sistema*/
    public UserEntity getUserId(Long userId){
        return userRepo.findById(userId).orElse(null);
    }
}
