package com.example.QuizApplication.service;

import com.example.QuizApplication.entity.UserQuizAttempt;

import java.util.List;

public interface UserQuizAttemptService {

  UserQuizAttempt saveUserQuizAttempt(UserQuizAttempt attempt);

  List<UserQuizAttempt> getUserAttemptsByUserId(Long userId);

  List<UserQuizAttempt> getUserAttemptsByQuizId(Long quizId);

}
