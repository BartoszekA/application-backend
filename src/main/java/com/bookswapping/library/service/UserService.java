package com.bookswapping.library.service;

import com.bookswapping.library.domain.User;
import com.bookswapping.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(final Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }
}
