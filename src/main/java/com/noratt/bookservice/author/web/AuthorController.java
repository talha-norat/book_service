package com.noratt.bookservice.author.web;

import com.noratt.bookservice.author.Author;
import com.noratt.bookservice.author.AuthorService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author talha
 */

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService authorService;

  @GetMapping
  public ResponseEntity<?> getAllAuthors() {
    return ResponseEntity.ok(authorService.getAllAuthors());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") UUID id) {
    return ResponseEntity.ok(authorService.getById(id));
  }

  @GetMapping("/findByName")
  public ResponseEntity<?> getById(@RequestParam("name") String name) {
    return ResponseEntity.ok(authorService.getByName(name));
  }

  @PostMapping
  public ResponseEntity<?> createAuthor(@RequestBody Author author) {
    return ResponseEntity.ok(authorService.createAuthor(author));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAuthor(@PathVariable("id") UUID id) {
    authorService.deleteAuthorById(id);
  }

  @DeleteMapping("/deleteByName")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAuthor(@RequestParam("name") String name) {
    authorService.deleteAuthorByName(name);
  }

}
