package com.gusta.bookservice.repository;

import com.gusta.bookservice.model.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
