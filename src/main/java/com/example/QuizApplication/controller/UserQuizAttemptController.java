package com.example.QuizApplication.controller;

import com.example.QuizApplication.entity.UserQuizAttempt;
import com.example.QuizApplication.service.UserQuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attempts")
public class UserQuizAttemptController {

  @Autowired
  private UserQuizAttemptService userQuizAttemptService;

  @PostMapping
  public ResponseEntity<UserQuizAttempt> saveUserQuizAttempt(@RequestBody UserQuizAttempt attempt) {
    attempt.setTimestamp(LocalDateTime.now());
    UserQuizAttempt savedAttempt = userQuizAttemptService.saveUserQuizAttempt(attempt);
    return ResponseEntity.ok(savedAttempt);
  }

  @GetMapping("/user/{userId}")
  public List<UserQuizAttempt> getUserAttemptsByUserId(@PathVariable Long userId) {
    return userQuizAttemptService.getUserAttemptsByUserId(userId);
  }

  @GetMapping("/quiz/{quizId}")
  public List<UserQuizAttempt> getUserAttemptsByQuizId(@PathVariable Long quizId) {
    return userQuizAttemptService.getUserAttemptsByQuizId(quizId);
  }

}

