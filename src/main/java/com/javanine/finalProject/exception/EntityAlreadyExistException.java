package com.javanine.finalProject.exception;

/**
 * Handler exception
 */
public class EntityAlreadyExistException extends RuntimeException {
    public EntityAlreadyExistException(String exception) {
        super(exception);
    }
}
