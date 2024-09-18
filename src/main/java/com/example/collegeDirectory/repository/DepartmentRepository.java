package com.example.collegeDirectory.repository;

import com.example.collegeDirectory.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for handling CRUD operations and custom queries for Department entities.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Finds a Department entity by its name.
     *
     * @param name the name of the department
     * @return an Optional containing the Department entity if found, otherwise empty
     */
    Optional<Department> findByName(String name);
}
