package com.zane.shop.repo;

import com.zane.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    List<User> findByStatus(String status);

    User findByStatusAndUsername(String status, String username);

    void deleteUserByUsername(String username);

    void deleteUserByUserId(Long userId);

    Optional<User> findByUsername(String username);
}

