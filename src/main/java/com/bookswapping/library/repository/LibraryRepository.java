package com.bookswapping.library.repository;

import com.bookswapping.library.domain.Library;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryRepository extends CrudRepository<Library, Long> {
    @Override
    List<Library> findAll();
}
