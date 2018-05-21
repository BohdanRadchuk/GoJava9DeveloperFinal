package com.javanine.finalProject.exception.handler;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class represents a body of exception message
 */
@Data
@NoArgsConstructor
public class ErrorBody {
    private Long timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;
}
