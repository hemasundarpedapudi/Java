package com.Student.Students.exception;

public class StudentNotFoundException extends RuntimeException{
    public  StudentNotFoundException(String message) {
        super(message);
    }
}
