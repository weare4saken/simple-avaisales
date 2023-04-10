package com.skypro.simpleaviasales.controller.handler;

import com.skypro.simpleaviasales.exception.FlightNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundHandler {
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(){
        return ResponseEntity.status(404).body("Такого рейса не существует.");
    }
}
