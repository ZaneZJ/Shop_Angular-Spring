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
                            "Email already exists!: " + t.getEmail());
                });
    }

    public User checkUsernameExists(String username) {
        Optional<User> userFromDBOpt = Optional.ofNullable(userRepo.findByStatusAndUsername("ACTIVE", username));
        return userFromDBOpt.orElseThrow(() ->
                new EntityDoesNotExistsException("Username: (" + username + ") does not exists!"));
    }

    // FIXME:
//    public void checkUserHaveService(User user, Long serviceId) {
//        if (!user.getServices().stream().map(Service::getUsername)
//                .collect(Collectors.toSet()).contains(serviceId)) {
//            throw new UserDoesNotHaveThatServiceException("user with username("
//                    + user.getUsername() + ") does not have service (" + serviceId + ")");
//        }
//    }

}
