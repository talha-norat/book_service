package com.noratt.bookservice.category;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author talha
 */

public interface CategoryRepository extends JpaRepository<Category, UUID> {

  Optional<Category> findByName(String name);

}
