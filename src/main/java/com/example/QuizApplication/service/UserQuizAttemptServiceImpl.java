package com.example.QuizApplication.service;

import com.example.QuizApplication.entity.UserQuizAttempt;
import com.example.QuizApplication.repository.UserQuizAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuizAttemptServiceImpl implements UserQuizAttemptService{

  @Autowired
  private UserQuizAttemptRepository userQuizAttemptRepository;

  @Override
  public UserQuizAttempt saveUserQuizAttempt(UserQuizAttempt attempt) {
    return userQuizAttemptRepository.save(attempt);
  }

  @Override
  public List<UserQuizAttempt> getUserAttemptsByUserId(Long userId) {
    return userQuizAttemptRepository.findAllByUserId(userId);
  }

  @Override
  public List<UserQuizAttempt> getUserAttemptsByQuizId(Long quizId) {
    return userQuizAttemptRepository.findAllByQuizId(quizId);
  }
}
