package com.example.QuizApplication.exception;

public class UserAlreadyExistsException extends Exception{
  public UserAlreadyExistsException(){
    super("User Already Exists");
  }
}
