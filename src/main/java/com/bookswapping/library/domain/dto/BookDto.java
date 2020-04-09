package com.bookswapping.library.domain.dto;

import com.bookswapping.library.domain.Library;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private int year;
    private String genre;
    private String state;
    private Library library;
}
