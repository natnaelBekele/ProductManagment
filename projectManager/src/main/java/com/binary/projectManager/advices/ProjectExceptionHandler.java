package com.binary.projectManager.advices;
import com.binary.projectManager.exceptions.ProjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProjectExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ProjectNotFoundException.class})
    public ResponseEntity<Object> handleProjectNotFoundException(ProjectNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", exception.getMessage());
        errorMap.put("timestamp", new Date().toString());
        errorMap.put("httpStatus", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        errorMap.put("timestamp", new Date().toString());
        errorMap.put("httpStatus", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
