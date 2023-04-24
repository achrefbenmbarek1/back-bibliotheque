package com.example.demo.Exception;

public class InvalidNameOrExtensionException extends RuntimeException{
   public InvalidNameOrExtensionException(String errorMessage){
        super(errorMessage);
    }
}

