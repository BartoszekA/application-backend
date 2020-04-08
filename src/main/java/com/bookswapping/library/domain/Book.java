package com.bookswapping.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "BOOKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "STATE")
    private String state;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
}
