package com.bookswapping.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "USER_ID")
    private Long id;
    private String name;
    private String email;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
    private String location;

    public User(String name, String email, String location) {
        this.name = name;
        this.email = email;
        this.location = location;
    }
}
