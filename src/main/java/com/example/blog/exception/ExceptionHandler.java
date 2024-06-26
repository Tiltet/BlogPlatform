package com.example.blog.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/** JavaDoc COMMENT. */
@SuppressWarnings({"checkstyle:Indentation", "checkstyle:LineLength"})
@RestControllerAdvice
public class ExceptionHandler extends HttpHeaders {

    /** ERROR 400. */
    @org.springframework.web.bind.annotation.ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<Message> handleIllegalArgumentException(HttpClientErrorException e) {
        String errorMessage = "ERROR 400: Http Client Error";
        return ResponseEntity.status(e.getStatusCode()).body(new Message(errorMessage, e.getMessage()));
    }

    /** ERROR 404 - localhost:8080/api/v1/user?id=1312. */
    @org.springframework.web.bind.annotation.ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Message> handleIllegalArgumentException(IllegalArgumentException e) {
        String errorMessage = "Error 404: Illegal Argument";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(errorMessage, e.getMessage()));
    }

    /** ERROR 404. */
    @org.springframework.web.bind.annotation.ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<Message> handleNoResourceFoundException(NoHandlerFoundException e) {
        String errorMessage = "ERROR 400: No Handler Found";
        return ResponseEntity.status(e.getStatusCode()).body(new Message(errorMessage, e.getMessage()));
    }

    /** ERROR 405 неправильный метод. */
    @org.springframework.web.bind.annotation.ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Message> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String errorMessage = "Error 405: Method Not Supported";
        return ResponseEntity.status(e.getStatusCode()).body(new Message(errorMessage, e.getMessage()));
    }

    /** ERROR 500 - "username": rere. */
    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Message> handlerRuntimeException(RuntimeException e) {
        String errorMessage = "Error 500: Runtime Exception";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Message(errorMessage, e.getMessage()));
    }


    /** ERROR 400 - localhost:8080/api/v1/user?id. */
    @org.springframework.web.bind.annotation.ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<Message> handlerRuntimeException(MissingServletRequestParameterException e) {
        String errorMessage = "Error 400: Bad Request";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message(errorMessage, e.getMessage()));
    }

    /** ERROR 404 - localhost:8080/api/v1/use. */
    @org.springframework.web.bind.annotation.ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<Message> noResourceFoundException(NoResourceFoundException e) {
        String errorMessage = "ERROR 404: No Resource Found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(errorMessage, e.getMessage()));
    }

    /** Default Exception. */
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<Message> exception(Exception e) {
        String errorMessage = "Error 500: Unknown Exception";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(errorMessage, e.getMessage()));
    }

    public record Message(String message, String description) {}
}