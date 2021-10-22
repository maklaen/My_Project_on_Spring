package com.pet.repository;

import com.pet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUsersByUsername(String username);

    Optional<User> findUsersByEmail(String email);

    Optional<User> findUsersById(Long id);

}