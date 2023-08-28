package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Api.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = DataIntegrityViolationException.class)//against check condition
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){

        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);}

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException e1) {
        String message=e1.getMessage();
        return ResponseEntity.status(400).body(message);

    }

    @ExceptionHandler(value = IncorrectResultSizeDataAccessException.class)
    public ResponseEntity IncorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException i){
        String message=i.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class )
    public ResponseEntity<ApiResponse> InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
        String msg=e.getMessage();
        return ResponseEntity.status(200).body(new ApiResponse(msg));
    }


    @ExceptionHandler(value = NullPointerException.class )
    public ResponseEntity<ApiResponse> NullPointerException(NullPointerException e){
        String msg=e.getMessage();
        return ResponseEntity.status(200).body(new ApiResponse(msg));
    }

}
