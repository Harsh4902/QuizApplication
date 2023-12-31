package com.example.QuizApplication.service;

import com.example.QuizApplication.entity.Question;

import java.util.List;

public interface QuestionService {

  List<Question> getQuestionsByQuizId(Long quizId);

  void addQuestionsList(List<Question> questionList);

  Question addQuestion(Question question);

  Question getQuestionById(Long id);

}
