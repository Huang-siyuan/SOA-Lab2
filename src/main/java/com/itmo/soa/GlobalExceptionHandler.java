package com.itmo.soa;

import com.itmo.soa.services.exceptions.InternalServerException;
import com.itmo.soa.services.exceptions.NoSuchObjException;
import com.itmo.soa.services.exceptions.ServiceException;
import com.itmo.soa.services.exceptions.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @program: SOA-Lab2
 * @description: We can use this to catch the exceptions and return the error message to the client
 * @author: Siyuan
 * @create: 2022-10-11 19:24
 **/

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<?> handleServiceException(RuntimeException ex) {
        if (ex instanceof NoSuchObjException) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }else if (ex instanceof ValidationException) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }else if (ex instanceof InternalServerException) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }

        return ResponseEntity.status(500).body("Unknown exception : "+ ex.getMessage());
    }
}
