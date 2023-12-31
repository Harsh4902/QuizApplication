package com.example.QuizApplication.controller;

import com.example.QuizApplication.entity.Quiz;
import com.example.QuizApplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {

  @Autowired
  private QuizService quizService;

  @GetMapping
  public List<Quiz> getAllQuizzes(){
    return quizService.getAllQuizzes();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
    Quiz quiz = quizService.getQuizById(id);
    return quiz != null ? ResponseEntity.ok(quiz) : ResponseEntity.notFound().build();
  }

  @PostMapping("/add")
  public ResponseEntity addQuiz(@RequestBody Quiz quiz){
    quizService.addQuiz(quiz);
    return new ResponseEntity(HttpStatus.CREATED);
  }

}
