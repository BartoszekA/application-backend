package com.bookswapping.library.repository;

import com.bookswapping.library.domain.Book;
import com.bookswapping.library.domain.Library;
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

    @Test
    public void shouldCrateUserWithLibrary() {
        //Given
        User user1 = new User();
        Library library = new Library();
        user1.setLibrary(library);

        //When
        int sizeBefore = userRepository.findAll().size();
        userRepository.save(user1);
        Long userId1 = user1.getId();
        int sizeAfter = userRepository.findAll().size();


        //Then
        Assert.assertNotEquals(sizeBefore, sizeAfter);

        //CleaunUp
        userRepository.deleteById(userId1);
    }

    @Test
    public void shouldCreateUserWithFullLibrary() {
        //Given
        User user = new User();
        Library library = new Library();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        //When
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        user.setLibrary(library);
        int librarySize = user.getLibrary().getBooks().size();

        //Then
        Assert.assertEquals(3, librarySize);
    }
}
