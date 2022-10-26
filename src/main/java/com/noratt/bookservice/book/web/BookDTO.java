package com.noratt.bookservice.book.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.noratt.bookservice.category.Category;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;

/**
 * @author talha
 */

@Data
public class BookDTO {

  @JsonProperty(access = Access.READ_ONLY)
  private UUID id;

  private String title;
  private String isbn;
  private String thumbnailUrl;
  private String status;
  private String shortDescription;
  private String longDescription;

  private LocalDateTime publishedDate;

  private Integer pageCount;

  private List<String> authors;

  private List<String> categories;
}
