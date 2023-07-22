package com.ravi.springapp.StudentManagementSystem.studentservice;


// Implementing Exception Handling  -- 404 Resource not found
// when request is made for non existing user

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFound extends RuntimeException {
    
    public StudentNotFound(String message){
        super(message);
    }

}
