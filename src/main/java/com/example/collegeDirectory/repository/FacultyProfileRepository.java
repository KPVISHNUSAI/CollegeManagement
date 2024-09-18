package com.example.collegeDirectory.repository;

import com.example.collegeDirectory.entity.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/**
 * Repository interface for handling CRUD operations and custom queries for FacultyProfile entities.
 */
@Repository
public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {

    /**
     * Finds a FacultyProfile entity by its associated user ID.
     *
     * @param userId the ID of the associated user
     * @return an Optional containing the FacultyProfile entity, or empty if no profile with the given user ID is found
     */
    Optional<FacultyProfile> findByUserId(Long userId);

    /**
     * Finds a FacultyProfile entity by the username of the associated user.
     *
     * @param username the username of the associated user
     * @return an Optional containing the FacultyProfile entity, or empty if no profile with the given username is found
     */
    Optional<FacultyProfile> findByUserUsername(String username);

    /**
     * Finds a list of FacultyProfile entities associated with a specific department.
     *
     * @param departmentId the ID of the department
     * @return a list of FacultyProfile entities associated with the given department ID
     */
    List<FacultyProfile> findByDepartmentId(Long departmentId);
}
