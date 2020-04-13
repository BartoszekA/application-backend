package com.bookswapping.library.controller;

import com.bookswapping.library.domain.BookNotFoundException;
import com.bookswapping.library.domain.dto.BookDto;
import com.bookswapping.library.mapper.BookMapper;
import com.bookswapping.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/v1")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<BookDto> getBookList() {
        return bookMapper.mapToBookDtoList(bookService.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(bookService.getBook(bookId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(bookService.saveBook(bookMapper.mapToBook(bookDto)));
    }
}
