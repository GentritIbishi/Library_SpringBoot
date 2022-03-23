package com.gentritibishi.library.repositories;

import com.gentritibishi.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
