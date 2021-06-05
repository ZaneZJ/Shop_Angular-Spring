package com.zane.shop.service;

import com.zane.shop.model.User;
import com.zane.shop.repo.UserRepo;
import com.zane.shop.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserValidator userValidator;

    @Autowired
    public UserService(UserRepo userRepo, UserValidator userValidator) {
        this.userRepo = userRepo;
        this.userValidator = userValidator;
    }

//    public User addUser(User user) {
//        user.setUser(UUID.fromString().toString());
//        return userRepo.save(user);
//    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepo.getOne(username);
    }

    public void softDeleteUser(String username){
        User user = userValidator.checkUserExists(username);
        user.setStatus("DELETED");
        userRepo.save(user);
    }
}
