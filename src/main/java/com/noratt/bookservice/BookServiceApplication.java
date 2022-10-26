package com.noratt.bookservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noratt.bookservice.book.Book;
import com.noratt.bookservice.book.BookRepository;
import com.noratt.bookservice.book.convert.BookDtoToBookConverter;
import com.noratt.bookservice.book.web.BookDTO;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class BookServiceApplication {

  private final BookRepository bookRepository;
  private final ObjectMapper objectMapper;
  private final BookDtoToBookConverter bookDtoToBookConverter;

  public static void main(String[] args) {
    SpringApplication.run(BookServiceApplication.class, args);
  }

  @PostConstruct
  public void init() {
    if(bookRepository.count() == 0) {
      try {
        File file = ResourceUtils.getFile("classpath:static/books.json");
        String content = new String(Files.readAllBytes(file.toPath()));

        List<BookDTO> dtos = objectMapper.readValue(content, new TypeReference<List<BookDTO>>() {});
        var books = dtos.stream().map(bookDtoToBookConverter::convert).collect(Collectors.toList());
        bookRepository.saveAll(books);
      }  catch (IOException ignored) {}
    }
  }

}
