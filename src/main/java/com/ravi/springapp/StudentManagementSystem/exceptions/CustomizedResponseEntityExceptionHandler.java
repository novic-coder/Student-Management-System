package com.ravi.springapp.StudentManagementSystem.exceptions;

// Exception handling for generic resources
// The Response shows a Customized Message Structure


import com.ravi.springapp.StudentManagementSystem.studentservice.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<com.
            ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails> handlesAllexceptions(Exception exception, WebRequest webRequest) throws  Exception{
      com.ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails errorDetails = new com.ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails(LocalDateTime.now(),
              exception.getMessage(),webRequest.getDescription(false));
      return new ResponseEntity<com.ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StudentNotFound.class)
    public final ResponseEntity<com.ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails> handlesUserNotFound(Exception exception, WebRequest webRequest) throws Exception {
        com.ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails errorDetails = new com.ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails(LocalDateTime.now(),
                exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<com.ravi.springapp.StudentManagementSystem.exceptions.ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }
}
