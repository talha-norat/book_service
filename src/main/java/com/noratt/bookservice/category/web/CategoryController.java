package com.noratt.bookservice.category.web;

import com.noratt.bookservice.category.CategoryService;
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
@RequestMapping("categories")
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<?> getAllCategories() {
    return ResponseEntity.ok(categoryService.getAllCategories());
  }
}
