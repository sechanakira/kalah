package com.backbase.kalah.controller.advice;

import com.backbase.kalah.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class KalahExceptionHandler {

    @ExceptionHandler(GameEndedException.class)
    public ApiError handleGameEndedException(GameEndedException ex){
        return createApiError(HttpStatus.BAD_REQUEST,ex);
    }

    @ExceptionHandler(InvalidGameIdException.class)
    public ApiError handleInvalidGameIdException(InvalidGameIdException ex){
        return createApiError(HttpStatus.BAD_REQUEST,ex);
    }

    @ExceptionHandler(GameNotFoundException.class)
    public ApiError handleGameNotFoundException(GameNotFoundException ex){
        return createApiError(HttpStatus.BAD_REQUEST,ex);
    }

    @ExceptionHandler(InvalidPitIdException.class)
    public ApiError handleInvalidPitIdException(InvalidPitIdException ex){
        return createApiError(HttpStatus.BAD_REQUEST,ex);
    }

    @ExceptionHandler(MissingVariableException.class)
    public ApiError handleMissingVariableException(MissingVariableException ex){
        return createApiError(HttpStatus.BAD_REQUEST,ex);
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleException(Exception ex){
        return createApiError(HttpStatus.INTERNAL_SERVER_ERROR,ex);
    }

    private ApiError createApiError(HttpStatus httpStatus, Exception ex){
        ApiError error = new ApiError(httpStatus,ex);
        return error;
    }
}
