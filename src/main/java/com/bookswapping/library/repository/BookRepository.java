package com.bookswapping.library.repository;

import com.bookswapping.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
