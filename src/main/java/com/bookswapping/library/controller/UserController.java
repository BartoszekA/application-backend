package com.bookswapping.library.controller;

import com.bookswapping.library.domain.User;
import com.bookswapping.library.domain.UserNotFoundException;
import com.bookswapping.library.domain.dto.UserDto;
import com.bookswapping.library.mapper.UserMapper;
import com.bookswapping.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUserList() {
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }
}
