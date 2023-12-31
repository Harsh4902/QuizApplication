package com.example.QuizApplication.service;

import com.example.QuizApplication.entity.Question;
import com.example.QuizApplication.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

  @Autowired
  private QuestionRepository questionRepository;

  @Override
  public List<Question> getQuestionsByQuizId(Long quizId) {
    return questionRepository.findAllByQuizId(quizId);
  }

  @Override
  public void addQuestionsList(List<Question> questionList) {
    questionRepository.saveAll(questionList);
  }

  @Override
  public Question addQuestion(Question question) {
    return questionRepository.save(question);
  }

  @Override
  public Question getQuestionById(Long id) {
    return questionRepository.getQuestionsById(id);
  }

}
