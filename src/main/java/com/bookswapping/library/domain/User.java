package com.bookswapping.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOCATION")
    private String location;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;

    public User(String name, String email, String location) {
        this.name = name;
        this.email = email;
        this.location = location;
    }
}
