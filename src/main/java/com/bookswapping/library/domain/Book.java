package com.bookswapping.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "BOOKS")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "BOOK_ID")
    private Long id;
    private String title;
    private String author;
    private int year;
    private String genre;
    private String state;
    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
}
