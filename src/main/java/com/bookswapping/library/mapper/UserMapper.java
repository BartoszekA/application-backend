package com.bookswapping.library.mapper;

import com.bookswapping.library.domain.User;
import com.bookswapping.library.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getLocation(),
                user.getLibrary()
        );
    }

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getLocation(),
                userDto.getLibrary()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(u -> new UserDto(u.getId(), u.getName(), u.getEmail(), u.getLocation(), u.getLibrary()))
                .collect(Collectors.toList());
    }
}
