package com.mongodb.crud.exception;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handle illegal argument exception api response.
     *
     * @param ex      the ex
     * @param request the request
     * @return the api response
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public APIResponse<Task> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return new APIResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    }

    /**
     * Handle duplicate resource exception api response.
     *
     * @param ex      the ex
     * @param request the request
     * @return the api response
     */
    @ExceptionHandler(DuplicateResourceException.class)
    public APIResponse<Task> handleDuplicateResourceException(DuplicateResourceException ex, WebRequest request) {
        return new APIResponse<>(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
    }

    /**
     * Handle resource not found exception api response.
     *
     * @param ex      the ex
     * @param request the request
     * @return the api response
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public APIResponse<Task> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new APIResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
    }
}
