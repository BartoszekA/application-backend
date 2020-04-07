package com.bookswapping.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "LIBRARIES")
@Getter
@Setter
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LIBRARY_ID")
    private Long id;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "LIBRARIES",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Book> bookList;

    @OneToOne(
            targetEntity = User.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private User user;
}
