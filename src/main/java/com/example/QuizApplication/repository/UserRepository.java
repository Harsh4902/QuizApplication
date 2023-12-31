package com.example.QuizApplication.repository;

import com.example.QuizApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

  Optional<User> findByEmail(String email);


}
