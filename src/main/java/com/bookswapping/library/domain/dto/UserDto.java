package com.bookswapping.library.domain.dto;

import com.bookswapping.library.domain.Library;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String location;
    private Library library;
}
