package com.example.collegeDirectory.repository;

import com.example.collegeDirectory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repository interface for handling CRUD operations and custom queries for User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User entity by its username.
     *
     * @param username the username of the user
     * @return the User entity, or null if no user with the given username is found
     */
    Optional<User> findByUsername(String username);
}
