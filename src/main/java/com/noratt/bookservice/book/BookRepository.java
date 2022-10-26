package com.noratt.bookservice.book;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author talha
 */


public interface BookRepository extends JpaRepository<Book, UUID> {

}
