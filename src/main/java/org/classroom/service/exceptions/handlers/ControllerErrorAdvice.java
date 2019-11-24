package org.classroom.service.exceptions.handlers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import org.classroom.service.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ControllerErrorAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handlePostNotFound(ResourceNotFoundException exception, HttpServletResponse response)
            throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }
}
