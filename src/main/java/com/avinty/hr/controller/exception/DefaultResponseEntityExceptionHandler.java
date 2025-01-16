package com.avinty.hr.controller.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class DefaultResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    public @ResponseBody ResponseEntity<Throwable> forwardExceptionToFrontEnd(Throwable t) {
        return ResponseEntity.internalServerError().body(t);
    }
}
