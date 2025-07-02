package br.com.study.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{

  public UnsupportedMathOperationException(String message) {
    super(message);
  }
}
