package com.noratt.bookservice.book.web;

import com.noratt.bookservice.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author talha
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("books")
public class BookController {

  private final BookService bookService;

  @GetMapping
  public ResponseEntity<?> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

}
