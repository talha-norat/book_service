package com.noratt.bookservice.author;

import com.noratt.bookservice.errors.ValidationError;
import com.noratt.bookservice.exceptions.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author talha
 */

@Service
@RequiredArgsConstructor
public class AuthorService {

  private final AuthorRepository authorRepository;

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public Author getById(UUID id) {
    return authorRepository.findById(id).orElseThrow();
  }

  public Author getByName(String name) {
    return authorRepository.findByName(name).orElseThrow();
  }

  public Author createAuthor(Author author) {
    validateAuthor(author);
    return authorRepository.save(author);
  }

  public void deleteAuthorById(UUID id) {
    var author = getById(id);
    authorRepository.delete(author);
  }

  public void deleteAuthorByName(String name) {
    var author = getByName(name);
    authorRepository.delete(author);
  }

  private void validateAuthor(Author author) {
    List<ValidationError> errors = new ArrayList<>();
    if(author.getName().isEmpty()) {
      errors.add(new ValidationError("Author.class","name","Name cannot be empty"));
      throw new ValidationException(errors);
    } else {
      var existing = authorRepository.findByName(author.getName());
      if(existing.isPresent()) {
        errors.add(new ValidationError("Author.class","name","Author with name already exists"));
        throw new ValidationException(errors);
      }
    }
  }
}
