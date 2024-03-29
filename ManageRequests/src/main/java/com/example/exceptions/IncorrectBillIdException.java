// com.example.exceptions.IncorrectBillIdException.java
package com.example.exceptions;

public class IncorrectBillIdException extends RuntimeException {
    public IncorrectBillIdException(String message) {
        super(message);
    }
}
