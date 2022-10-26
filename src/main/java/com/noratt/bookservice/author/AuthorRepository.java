package com.noratt.bookservice.author;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author talha
 */

public interface AuthorRepository extends JpaRepository<Author, UUID> {

  Optional<Author> findByName(String name);

}
