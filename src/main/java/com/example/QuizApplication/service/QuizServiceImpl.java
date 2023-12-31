package com.example.QuizApplication.service;

import com.example.QuizApplication.entity.Quiz;
import com.example.QuizApplication.repository.QuizRepository;
import com.example.QuizApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

  @Autowired
  private QuizRepository quizRepository;

  @Override
  public List<Quiz> getAllQuizzes() {
    return quizRepository.findAll();
  }

  @Override
  public Quiz getQuizById(Long id) {
    return quizRepository.findById(id).orElse(null);
  }

  @Override
  public void addQuiz(Quiz quiz) {
    quizRepository.save(quiz);
  }
}
