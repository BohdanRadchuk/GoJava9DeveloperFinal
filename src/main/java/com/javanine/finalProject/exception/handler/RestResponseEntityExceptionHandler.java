package com.javanine.finalProject.exeption.handler;

import com.javanine.finalProject.exeption.EntityAlreadyExistException;
import com.javanine.finalProject.exeption.EntityConstraintException;
import com.javanine.finalProject.exeption.EntityNullException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

/**
 * The class contains total handler exceptions for all rest-layer.
 */
@ControllerAdvice(annotations = RestController.class)
public class RestResponseEntityExceptionHandler {
    /**
     * The method transforms an exception {@link EntityNotFoundException} to the mode of {@link ErrorBody}
     *
     * @param ex      - gotten exception
     * @param request - HTTP request
     * @return response entity
     */
    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorBody> handleNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        ErrorBody errorBody = getErrorBody(ex, request, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorBody, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    /**
     * The method transforms an exception {@link EntityNullException} to the mode of {@link ErrorBody}
     *
     * @param ex      - gotten exception
     * @param request - HTTP request
     * @return response entity
     */
    @ExceptionHandler(value = {EntityNullException.class})
    protected ResponseEntity<ErrorBody> handleEntityNull(EntityNullException ex, HttpServletRequest request) {
        ErrorBody errorBody = getErrorBody(ex, request, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorBody, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * The method transforms an exception {@link EntityConstraintException} to the mode of {@link ErrorBody}
     *
     * @param ex      - gotten exception
     * @param request - HTTP request
     * @return response entity
     */
    @ExceptionHandler(value = {EntityConstraintException.class})
    protected ResponseEntity<ErrorBody> handleEntityConstraint(EntityConstraintException ex, HttpServletRequest request) {
        ErrorBody errorBody = getErrorBody(ex, request, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorBody, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * The method transforms an exception {@link EntityAlreadyExistException} to the mode of {@link ErrorBody}
     *
     * @param ex      - gotten exception
     * @param request - HTTP request
     * @return response entity
     */
    @ExceptionHandler(value = {EntityAlreadyExistException.class})
    protected ResponseEntity<ErrorBody> handleEntityConstraint(EntityAlreadyExistException ex, HttpServletRequest request) {
        ErrorBody errorBody = getErrorBody(ex, request, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorBody, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * The method for transform a message of exception to the mode of {@link ErrorBody}
     *
     * @param ex      - gotten exception
     * @param request - HTTP request
     * @param status  - HTTP STATUS
     * @return - message in a new mode
     */
    private ErrorBody getErrorBody(Exception ex, HttpServletRequest request, HttpStatus status) {
        ErrorBody errorBody = new ErrorBody();
        errorBody.setTimestamp(System.nanoTime());
        errorBody.setError(status.getReasonPhrase());
        errorBody.setStatus(status.value());
        errorBody.setException(ex.getClass().getName());
        errorBody.setMessage(ex.getMessage());
        errorBody.setPath(request.getRequestURI());
        return errorBody;
    }
}
