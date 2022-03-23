package com.gentritibishi.library.repositories;

import com.gentritibishi.library.models.BookHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookHolderRepository extends JpaRepository<BookHolder, Long> {
}
