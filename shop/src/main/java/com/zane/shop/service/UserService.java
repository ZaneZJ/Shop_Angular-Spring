package com.zane.shop.service;

import com.zane.shop.exception.UsernameNotFoundException;
import com.zane.shop.model.User;
import com.zane.shop.repo.UserRepo;
import com.zane.shop.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
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

    public void softDeleteUser(String username){
        User user = userValidator.checkUsernameExists(username);
        user.setStatus("DELETED");
        userRepo.save(user);
    }

    // OR:

    public void deleteUser(String username){
        userRepo.deleteUserByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User userId) {
        return userRepo.save(userId);
    }

    public User getUserByUsername(String username) {
        return userRepo.getOne(username);
    }

    // OR:

    public User findByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " was not found!"));
    }

    public User addUser(User user) {
        // FIXME: insert it manually
//        user.setUsername(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

}
