package com.example.demo.Exception;

public class ProblemWhenSavingBookCoverException extends RuntimeException{
   public ProblemWhenSavingBookCoverException(String errorMessage){
        super(errorMessage);
    }
}

