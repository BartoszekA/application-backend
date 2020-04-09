package com.bookswapping.library.mapper;

import com.bookswapping.library.domain.Library;
import com.bookswapping.library.domain.dto.LibraryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {
    public LibraryDto mapToLibraryDto(final Library library) {
        return new LibraryDto(
                library.getId(),
                library.getBooks()
        );
    }

    public Library mapToLibrary(final LibraryDto libraryDto) {
        return new Library(
                libraryDto.getId(),
                libraryDto.getBooks()
        );
    }

    public List<LibraryDto> mapToLibraryDtoList(final List<Library> libraryList) {
        return libraryList.stream()
                .map(l -> new LibraryDto(l.getId(), l.getBooks()))
                .collect(Collectors.toList());
    }
}
