package com.noratt.bookservice.errors;

/**
 * @author talha
 */

public record ValidationError(String object, String field,
                              String message) {
}
