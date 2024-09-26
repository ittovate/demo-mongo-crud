package com.mongodb.crud.exception;

import com.mongodb.crud.entity.Task;
import com.mongodb.crud.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle null resource exception api response.
     *
     * @param ex      the ex
     * @param request the request
     * @return the api response
     */
    @ExceptionHandler(NullResourceException.class)
    public ApiResponse<Task> handleNullResourceException(NullResourceException ex, WebRequest request) {
        return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    }

    /**
     * Handle illegal argument exception api response.
     *
     * @param ex      the ex
     * @param request the request
     * @return the api response
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse<Task> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    }

    /**
     * Handle duplicate resource exception api response.
     *
     * @param ex      the ex
     * @param request the request
     * @return the api response
     */
    @ExceptionHandler(DuplicateResourceException.class)
    public ApiResponse<Task> handleDuplicateResourceException(DuplicateResourceException ex, WebRequest request) {
        return new ApiResponse<>(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
    }

    /**
     * Handle resource not found exception api response.
     *
     * @param ex      the ex
     * @param request the request
     * @return the api response
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Task> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
    }
}
