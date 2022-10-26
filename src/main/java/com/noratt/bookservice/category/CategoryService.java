package com.noratt.bookservice.category;

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

@RequiredArgsConstructor
@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public Category getById(UUID id) {
    return categoryRepository.findById(id).orElseThrow();
  }

  public Category getByName(String name) {
    return categoryRepository.findByName(name).orElseThrow();
  }

  public Category createCategory(Category category) {
    validateCategory(category);
    return categoryRepository.save(category);
  }

  public void deleteCategoryById(UUID id) {
    var category = getById(id);
    categoryRepository.delete(category);
  }

  public void deleteCategoryByName(String name) {
    var category = getByName(name);
    categoryRepository.delete(category);
  }

  private void validateCategory(Category category) {
    List<ValidationError> errors = new ArrayList<>();
    if(category.getName().isEmpty()) {
      errors.add(new ValidationError("Category.class","name","Name cannot be empty"));
      throw new ValidationException(errors);
    } else {
      var existing = categoryRepository.findByName(category.getName());
      if(existing.isPresent()) {
        errors.add(new ValidationError("Category.class","name","Category with name already exists"));
        throw new ValidationException(errors);
      }
    }
  }
}
