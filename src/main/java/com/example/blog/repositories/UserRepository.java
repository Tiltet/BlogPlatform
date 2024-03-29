package com.example.blog.repositories;

import com.example.blog.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@SuppressWarnings("checkstyle:Indentation")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.blogs")
    List<User> findAllAuthors();
}
