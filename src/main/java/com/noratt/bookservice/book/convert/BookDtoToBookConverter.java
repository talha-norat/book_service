package com.noratt.bookservice.book.convert;

import com.noratt.bookservice.author.Author;
import com.noratt.bookservice.author.AuthorRepository;
import com.noratt.bookservice.book.Book;
import com.noratt.bookservice.book.web.BookDTO;
import com.noratt.bookservice.category.Category;
import com.noratt.bookservice.category.CategoryRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author talha
 */

@RequiredArgsConstructor
@Component
public class BookDtoToBookConverter implements Converter<BookDTO, Book> {

  private final AuthorRepository authorRepository;
  private final CategoryRepository categoryRepository;

  @Override
  public Book convert(BookDTO source) {
    var book = Book.builder()
        .isbn(source.getIsbn())
        .title(source.getTitle())
        .thumbnailUrl(source.getThumbnailUrl())
        .pageCount(source.getPageCount())
        .publishedDate(source.getPublishedDate())
        .status(source.getStatus())
        .shortDescription(source.getShortDescription())
        .longDescription(source.getLongDescription())
        .authors(getAuthors(source.getAuthors()))
        .categories(getCategories(source.getCategories()))
        .build();
    return book;
  }

  @Transactional
  public List<Author> getAuthors(List<String> authorList) {
    List<Author> authors = new ArrayList<>();

    authorList.forEach(name -> {
      var author = authorRepository.findByName(name.trim()).orElse(null);
      if(author == null) {
        author = Author.builder().name(name.trim()).build();
        author = authorRepository.save(author);
      }
      authors.add(author);
    });

    return authors;
  }

  @Transactional
  public List<Category> getCategories(List<String> categoryList) {
    List<Category> categories = new ArrayList<>();

    categoryList.forEach(name -> {
      var category = categoryRepository.findByName(name.trim()).orElse(null);
      if(category == null) {
        category = Category.builder().name(name.trim()).build();
        category = categoryRepository.save(category);
      }
      categories.add(category);
    });

    return categories;
  }
}
