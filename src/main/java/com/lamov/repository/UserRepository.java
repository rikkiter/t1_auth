package com.lamov.repository;

import com.lamov.database.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByLogin(String login);
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
}
