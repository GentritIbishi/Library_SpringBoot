package com.gentritibishi.library.repositories;

import com.gentritibishi.library.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
