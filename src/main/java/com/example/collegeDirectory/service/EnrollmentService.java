package com.example.collegeDirectory.service;

import com.example.collegeDirectory.entity.Course;
import com.example.collegeDirectory.entity.Enrollment;
import com.example.collegeDirectory.entity.StudentProfile;
import com.example.collegeDirectory.exception.ResourceNotFoundException;
import com.example.collegeDirectory.repository.CourseRepository;
import com.example.collegeDirectory.repository.EnrollmentRepository;
import com.example.collegeDirectory.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling business logic related to enrollments.
 */
@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Enrolls a student in a course.
     *
     * @param studentId the ID of the student
     * @param courseId  the ID of the course
     * @return the created Enrollment entity
     * @throws ResourceNotFoundException if the student or course is not found
     */
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        
        Enrollment enrollment = new Enrollment(student, course);
        return enrollmentRepository.save(enrollment);
    }

    /**
     * Finds all enrollments for a specific student.
     *
     * @param studentId the ID of the student
     * @return a list of Enrollment entities
     * @throws ResourceNotFoundException if the student is not found
     */
    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        if (!studentProfileRepository.existsById(studentId)) {
            throw new ResourceNotFoundException("Student not found with id " + studentId);
        }
        
        return enrollmentRepository.findByStudentId(studentId);
    }

    /**
     * Finds all enrollments for a specific course.
     *
     * @param courseId the ID of the course
     * @return a list of Enrollment entities
     * @throws ResourceNotFoundException if the course is not found
     */
    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new ResourceNotFoundException("Course not found with id " + courseId);
        }
        
        return enrollmentRepository.findByCourseId(courseId);
    }

    /**
     * Finds a specific enrollment by student and course.
     *
     * @param studentId the ID of the student
     * @param courseId  the ID of the course
     * @return the Enrollment entity
     * @throws ResourceNotFoundException if the enrollment is not found
     */
    public Enrollment getEnrollment(Long studentId, Long courseId) {
        Enrollment enrollment = enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId);
        
        if (enrollment == null) {
            throw new ResourceNotFoundException("Enrollment not found for student id " + studentId + " and course id " + courseId);
        }
        
        return enrollment;
    }

    /**
     * Deletes a specific enrollment by student and course.
     *
     * @param studentId the ID of the student
     * @param courseId  the ID of the course
     * @throws ResourceNotFoundException if the enrollment is not found
     */
    public void deleteEnrollment(Long studentId, Long courseId) {
        Enrollment enrollment = enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId);
        
        if (enrollment == null) {
            throw new ResourceNotFoundException("Enrollment not found for student id " + studentId + " and course id " + courseId);
        }
        
        enrollmentRepository.delete(enrollment);
    }
}
