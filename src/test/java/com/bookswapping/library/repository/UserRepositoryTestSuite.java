package com.bookswapping.library.repository;

import com.bookswapping.library.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldCreateUser() {
        //Given
        User user1 = new User("User1", "email@email.com", "Warsaw");

        //When
        userRepository.save(user1);

        //Then
        Long id = user1.getId();
        Optional<User> readUser = userRepository.findById(id);
        Assert.assertTrue(readUser.isPresent());

        //CleaunUp
        userRepository.deleteById(id);
    }


}
