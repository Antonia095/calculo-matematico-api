package br.com.study.exception.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import br.com.study.exception.ExceptionResponse;
import br.com.study.exception.UnsupportedMathOperationException;
import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {

    ExceptionResponse response = new ExceptionResponse(
        new Date(),
        ex.getMessage(),
        request.getDescription(false)
    );

    return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UnsupportedMathOperationException.class)
  public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {

    ExceptionResponse response = new ExceptionResponse(
        new Date(),
        ex.getMessage(),
        request.getDescription(false)
    );

    return new ResponseEntity<>(response, BAD_REQUEST);
  }



}
