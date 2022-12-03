package com.sojuthon.sojuthonbackend.exception;

import java.time.LocalDateTime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static String getSimpleName(Exception e) {
        return e.getClass().getSimpleName();
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicatePhoneException.class)
    public ErrorMsg handleDuplicateMemberIdException(DuplicatePhoneException e) {
        return ErrorMsg.builder()
                .msg(e.getLocalizedMessage())
                .errorCode(getSimpleName(e))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLoginException.class)
    public ErrorMsg handleNotLoginException(NotLoginException e) {
        return ErrorMsg.builder()
                .msg(e.getLocalizedMessage())
                .errorCode(getSimpleName(e))
                .timestamp(LocalDateTime.now())
                .build();
    }
}