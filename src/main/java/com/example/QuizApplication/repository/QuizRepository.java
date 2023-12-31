package com.example.QuizApplication.repository;

import com.example.QuizApplication.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {



}
