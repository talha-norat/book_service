package com.noratt.bookservice.category.web;

import com.noratt.bookservice.category.Category;
import com.noratt.bookservice.category.CategoryService;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<?> getAllCategories() {
    return ResponseEntity.ok(categoryService.getAllCategories());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") UUID id) {
    return ResponseEntity.ok(categoryService.getById(id));
  }

  @GetMapping("/findByName")
  public ResponseEntity<?> getById(@RequestParam("name") String name) {
    return ResponseEntity.ok(categoryService.getByName(name));
  }

  @PostMapping
  public ResponseEntity<?> createCategory(@RequestBody Category category) {
    return ResponseEntity.ok(categoryService.createCategory(category));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCategory(@PathVariable("id") UUID id) {
    categoryService.deleteCategoryById(id);
  }

  @DeleteMapping("/deleteByName")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCategory(@RequestParam("name") String name) {
    categoryService.deleteCategoryByName(name);
  }
}
