package com.example.QuizApplication.repository;

import com.example.QuizApplication.entity.UserQuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserQuizAttemptRepository extends JpaRepository<UserQuizAttempt,Long> {

  List<UserQuizAttempt> findAllByUserId(Long id);

  List<UserQuizAttempt> findAllByQuizId(Long id);

}
