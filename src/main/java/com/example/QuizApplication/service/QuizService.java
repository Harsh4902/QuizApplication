package com.example.QuizApplication.service;

import com.example.QuizApplication.entity.Quiz;

import java.util.List;

public interface QuizService {

  List<Quiz> getAllQuizzes();

  Quiz getQuizById(Long id);

  void addQuiz(Quiz quiz);

}
