package com.javanine.finalProject.exception;

/**
 * Exception for entity.
 */
public class EntityConstraintException extends RuntimeException {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public EntityConstraintException(String message) {
        super(message);
    }
}
