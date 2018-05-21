package com.javanine.finalProject.exeption;

/**
 * Handler exception
 */
public class EntityAlreadyExistException extends RuntimeException {
    public EntityAlreadyExistException(String exception) {
        super(exception);
    }
}
