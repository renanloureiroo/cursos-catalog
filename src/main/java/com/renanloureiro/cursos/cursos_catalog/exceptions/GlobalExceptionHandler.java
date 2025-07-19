package com.renanloureiro.cursos.cursos_catalog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryNotFound(CategoryNotFoundException ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, "Categoria não encontrada");
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCourseNotFound(CourseNotFoundException ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, "Curso não encontrado");
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidInput(InvalidInputException ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, "Entrada inválida");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, "Bad Request");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        return createErrorResponse("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    private ResponseEntity<Map<String, Object>> createErrorResponse(String message, HttpStatus status, String error) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", message);
        errorResponse.put("status", status.value());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("error", error);
        
        return ResponseEntity.status(status).body(errorResponse);
    }
} 