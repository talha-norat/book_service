package com.noratt.bookservice.exceptions;

import com.noratt.bookservice.errors.ValidationError;
import java.io.Serial;
import java.util.List;
import org.springframework.validation.Errors;

/**
 * @author talha
 */


public class ValidationException extends RuntimeException {

  private final List<ValidationError> errors;

  public ValidationException(List<ValidationError> errors) {
    super("Validation failed");
    this.errors = errors;
  }

  public List<ValidationError> getErrors() {
    return errors;
  }

}
