// com.example.exceptions.EmptyUserIdException.java
package com.example.exceptions;

public class EmptyUserIdException extends RuntimeException {
    public EmptyUserIdException(String message) {
        super(message);
    }
}
