package com.example.collegeDirectory.repository;

import com.example.collegeDirectory.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for handling CRUD operations and custom queries for Enrollment entities.
 */
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    /**
     * Finds a list of Enrollment entities associated with a specific student.
     *
     * @param studentId the ID of the student
     * @return a list of Enrollment entities associated with the given student ID
     */
    List<Enrollment> findByStudentId(Long studentId);

    /**
     * Finds a list of Enrollment entities associated with a specific course.
     *
     * @param courseId the ID of the course
     * @return a list of Enrollment entities associated with the given course ID
     */
    List<Enrollment> findByCourseId(Long courseId);

    /**
     * Finds an Enrollment entity by its student ID and course ID.
     *
     * @param studentId the ID of the student
     * @param courseId  the ID of the course
     * @return an Enrollment entity associated with the given student ID and course ID
     */
    Enrollment findByStudentIdAndCourseId(Long studentId, Long courseId);
}
