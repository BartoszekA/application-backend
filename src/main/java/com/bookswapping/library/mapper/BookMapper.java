package com.bookswapping.library.mapper;

import com.bookswapping.library.domain.Book;
import com.bookswapping.library.domain.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                book.getGenre(),
                book.getState(),
                book.getLibrary()
        );
    }

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYear(),
                bookDto.getGenre(),
                bookDto.getState(),
                bookDto.getLibrary()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(b -> new BookDto(b.getId(),
                        b.getTitle(),
                        b.getAuthor(),
                        b.getYear(),
                        b.getGenre(),
                        b.getState(),
                        b.getLibrary()))
                .collect(Collectors.toList());
    }
}
