package com.example.QuizApplication.repository;

import com.example.QuizApplication.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

  List<Question> findAllByQuizId(Long id);

  Question getQuestionsById(Long id);

}
