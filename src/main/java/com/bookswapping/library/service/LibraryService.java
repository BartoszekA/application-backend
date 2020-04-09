package com.bookswapping.library.service;

import com.bookswapping.library.domain.Library;
import com.bookswapping.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public Library saveLibrary(final Library library) {
        return libraryRepository.save(library);
    }

    public Optional<Library> getLibrary(final Long libraryId) {
        return libraryRepository.findById(libraryId);
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public void deleteLibrary(final Long libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
