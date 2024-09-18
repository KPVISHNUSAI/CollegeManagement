package com.example.collegeDirectory.repository;

import com.example.collegeDirectory.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for handling CRUD operations and custom queries for Course entities.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * Finds a list of Course entities associated with a specific department.
     *
     * @param departmentId the ID of the department
     * @return a list of Course entities associated with the given department ID
     */
    List<Course> findByDepartmentId(Long departmentId);

    /**
     * Finds a list of Course entities associated with a specific faculty member.
     *
     * @param facultyId the ID of the faculty member
     * @return a list of Course entities associated with the given faculty ID
     */
    List<Course> findByFacultyId(Long facultyId);

    /**
     * Finds a Course entity by its title.
     *
     * @param title the title of the course
     * @return a Course entity with the given title
     */
    Course findByTitle(String title);
}
