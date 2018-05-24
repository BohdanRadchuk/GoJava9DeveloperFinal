package com.javanine.finalProject.exception;

/**
 * Exception for entity.
 */
public class EntityAlreadyExistException extends RuntimeException {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public EntityAlreadyExistException(String message) {
        super(message);
    }
}
