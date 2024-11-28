package org.rabin.product.handler;

/*
 * @author : rabin
 */

import jakarta.persistence.EntityNotFoundException;
import org.rabin.product.exception.ProductPurchaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice // Indicates that this class provides global exception handling for controllers
public class GlobalExceptionHandler {

    // Handle exceptions of type CustomerNotFoundException
    @ExceptionHandler(ProductPurchaseException.class)
    public ResponseEntity<String> handle(ProductPurchaseException exp){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Respond with a 404 Not Found status
                .body(exp.getMessage()); // Return the exception message in the response body
    }

    // Handle exceptions of type CustomerNotFoundException
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException  exp){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Respond with a 404 Not Found status
                .body(exp.getMessage()); // Return the exception message in the response body
    }

    // Handle exceptions of type MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exp){
        var errors = new HashMap<String, String>();

        // Iterate through validation errors and map field names to error messages
        exp.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldName = ((FieldError)error).getField(); // Extract the field name that caused the error
                    var errorMessage = error.getDefaultMessage(); // Get the default error message
                    errors.put(fieldName, errorMessage); // Add the field name and error message to the map
                });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Respond with a 400 Bad Request status
                .body(new ErrorResponse(errors)); // Return the validation errors in the response body
    }

}
