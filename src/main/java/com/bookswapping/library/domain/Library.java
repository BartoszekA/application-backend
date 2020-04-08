package com.bookswapping.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "LIBRARIES")
@Getter
@Setter
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "library",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();
}
