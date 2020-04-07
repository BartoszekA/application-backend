package com.bookswapping.library.repository;

import com.bookswapping.library.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
