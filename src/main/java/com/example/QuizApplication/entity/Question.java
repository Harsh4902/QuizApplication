package com.example.QuizApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @ElementCollection
  private List<String> options;

  private int correctOption;

  @ManyToOne
  private Quiz quiz;

}
