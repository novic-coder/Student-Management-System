package com.ravi.springapp.StudentManagementSystem.exceptions;
import java.time.LocalDateTime;


public class ErrorDetails {

    // Implementation of Generic Exception Handling for all Resource

    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }


}
