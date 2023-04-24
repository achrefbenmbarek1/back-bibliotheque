package com.example.demo.Exception;

public class ProblemWhenDeletingBookCover extends RuntimeException{
   public ProblemWhenDeletingBookCover(String errorMessage){
        super(errorMessage);
    }
}

