package com.bookswapping.library.domain.dto;

import com.bookswapping.library.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class LibraryDto {
    private Long id;
    private List<Book> books;
}
