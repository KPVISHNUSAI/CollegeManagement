package com.example.collegeDirectory.repository;

import com.example.collegeDirectory.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for handling CRUD operations and custom queries for StudentProfile entities.
 */
@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    /**
     * Finds a StudentProfile entity by its associated user ID.
     *
     * @param userId the ID of the associated user
     * @return an Optional containing the StudentProfile entity, or empty if no profile with the given user ID is found
     */
    Optional<StudentProfile> findByUserId(Long userId);

    /**
     * Finds a StudentProfile entity by the username of the associated user.
     *
     * @param username the username of the associated user
     * @return an Optional containing the StudentProfile entity, or empty if no profile with the given username is found
     */
    Optional<StudentProfile> findByUserUsername(String username);
}
