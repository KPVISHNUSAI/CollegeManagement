package com.example.collegeDirectory.repository;

import com.example.collegeDirectory.entity.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/**
 * Repository interface for handling CRUD operations and custom queries for AdministratorProfile entities.
 */
@Repository
public interface AdminProfileRepository extends JpaRepository<AdministratorProfile, Long> {

    /**
     * Finds an AdministratorProfile entity by its associated user ID.
     *
     * @param userId the ID of the associated user
     * @return an Optional containing the AdministratorProfile entity, or empty if no profile with the given user ID is found
     */
    Optional<AdministratorProfile> findByUserId(Long userId);

    /**
     * Finds an AdministratorProfile entity by the username of the associated user.
     *
     * @param username the username of the associated user
     * @return an Optional containing the AdministratorProfile entity, or empty if no profile with the given username is found
     */
    Optional<AdministratorProfile> findByUserUsername(String username);

    /**
     * Finds a list of AdministratorProfile entities associated with a specific department.
     *
     * @param departmentId the ID of the department
     * @return a list of AdministratorProfile entities associated with the given department ID
     */
    List<AdministratorProfile> findByDepartmentId(Long departmentId);
}
