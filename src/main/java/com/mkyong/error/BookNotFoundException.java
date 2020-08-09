package com.mkyong.error;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long employeeId) {
        super("Employee Id not found : " + employeeId);
    }

}