package com.bookswapping.library.repository;

import com.bookswapping.library.domain.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}
