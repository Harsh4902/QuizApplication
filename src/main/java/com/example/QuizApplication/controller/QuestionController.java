package com.example.QuizApplication.controller;

import com.example.QuizApplication.entity.Question;
import com.example.QuizApplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @GetMapping("/quiz/{quizId}")
  public List<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
    return questionService.getQuestionsByQuizId(quizId);
  }

  @PostMapping("/add-list")
  public ResponseEntity addQuestions(@RequestBody List<Question> questionList){
    questionService.addQuestionsList(questionList);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @PostMapping("/add")
  public ResponseEntity<Question> addQuestion(@RequestBody Question question){
    return new ResponseEntity<>(questionService.addQuestion(question),HttpStatus.CREATED);
  }

  @PutMapping("/{questionId}")
  public ResponseEntity<Question> updateQuestion(@RequestBody Question question,@PathVariable Long questionId){

    Question question1 = questionService.getQuestionById(questionId);

    question1.setContent(question.getContent());
    question1.setOptions(question.getOptions());

    return new ResponseEntity<>(questionService.addQuestion(question1),HttpStatus.OK);
  }

}

