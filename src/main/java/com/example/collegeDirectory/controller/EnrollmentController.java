package com.example.collegeDirectory.controller;

import com.example.collegeDirectory.dto.EnrollmentDTO;
import com.example.collegeDirectory.entity.Enrollment;
import com.example.collegeDirectory.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing enrollments.
 */
@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    /**
     * Enrolls a student in a course.
     *
     * @param enrollmentDTO the enrollment data transfer object
     * @return the created Enrollment entity
     */
    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentService.enrollStudent(enrollmentDTO.getStudentId(), enrollmentDTO.getCourseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }

    /**
     * Finds all enrollments for a specific student.
     *
     * @param studentId the ID of the student
     * @return a list of Enrollment entities
     */
    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudent(@PathVariable Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
        return ResponseEntity.ok(enrollments);
    }

    /**
     * Finds all enrollments for a specific course.
     *
     * @param courseId the ID of the course
     * @return a list of Enrollment entities
     */
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByCourse(@PathVariable Long courseId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourse(courseId);
        return ResponseEntity.ok(enrollments);
    }

    /**
     * Finds a specific enrollment by student and course.
     *
     * @param studentId the ID of the student
     * @param courseId  the ID of the course
     * @return the Enrollment entity
     */
    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> getEnrollment(@PathVariable Long studentId, @PathVariable Long courseId) {
        Enrollment enrollment = enrollmentService.getEnrollment(studentId, courseId);
        return ResponseEntity.ok(enrollment);
    }

    /**
     * Deletes a specific enrollment by student and course.
     *
     * @param studentId the ID of the student
     * @param courseId  the ID of the course
     * @return a response with no content
     */
    @DeleteMapping("/{studentId}/{courseId}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long studentId, @PathVariable Long courseId) {
        enrollmentService.deleteEnrollment(studentId, courseId);
        return ResponseEntity.noContent().build();
    }
}
