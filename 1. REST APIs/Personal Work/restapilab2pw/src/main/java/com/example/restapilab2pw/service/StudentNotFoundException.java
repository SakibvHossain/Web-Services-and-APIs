package com.example.restapilab2pw.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException() {
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
