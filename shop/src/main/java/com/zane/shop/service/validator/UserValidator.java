package com.zane.shop.service.validator;

import com.zane.shop.exception.EmailAlreadyExistsException;
import com.zane.shop.exception.EntityDoesNotExistsException;
import com.zane.shop.model.Service;
import com.zane.shop.model.User;
import com.zane.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserValidator {

    private final UserRepo userRepo;

    @Autowired
    public UserValidator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void checkUserEmailDoesNotExists(String email) {
        User user = new User();
        user.setEmail(email);
        Example<User> userExample = Example.of(user);
        userRepo.findOne(userExample)
                .ifPresent(t -> {
                    throw new EmailAlreadyExistsException(
                            "Email AlreadyExists!: " + t.getEmail());
                });
    }

    public User checkUserExists(String username) {
        Optional<User> userFromDBOpt = Optional.ofNullable(userRepo.findByStatusAndUsername("ACTIVE", username));
        return userFromDBOpt.orElseThrow(() ->
                new EntityDoesNotExistsException("User: (" + username + ") not exists!"));
    }

    public void checkUserHaveService(User username, Long serviceId) {
        if (!username.getServices().stream().map(Service::getId)
                .collect(Collectors.toSet()).contains(serviceId)) {
            throw new UserDoesNotHaveThatServiceException("user("
                    + username.getId() + ") does not have book (" + serviceId + ")");
        }
    }

}
