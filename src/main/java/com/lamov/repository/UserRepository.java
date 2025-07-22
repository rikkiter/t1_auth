package com.lamov.repository;

import com.lamov.database.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByLogin(String login);
}
