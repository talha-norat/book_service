package com.noratt.bookservice.book;


import com.noratt.bookservice.author.Author;
import com.noratt.bookservice.category.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author talha
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Book {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  private String title;
  private String isbn;
  private String thumbnailUrl;
  private String status;

  @Column(length = 3000)
  private String shortDescription;

  @Column(length = Integer.MAX_VALUE)
  private String longDescription;

  private LocalDateTime publishedDate;

  private Integer pageCount;

  @ManyToMany(cascade = CascadeType.MERGE)
  private List<Author> authors = new ArrayList<>();

  @ManyToMany(cascade = CascadeType.MERGE)
  private List<Category> categories = new ArrayList<>();

}
