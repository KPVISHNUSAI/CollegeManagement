package com.example.collegeDirectory.service;

import com.example.collegeDirectory.entity.Course;
import com.example.collegeDirectory.exception.ResourceNotFoundException;
import com.example.collegeDirectory.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Retrieve a course by its ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

    // Create a new course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Update an existing course
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));

        // Updating fields based on the existing Course.java
        course.setTitle(courseDetails.getTitle());
        course.setDescription(courseDetails.getDescription());
        course.setDepartment(courseDetails.getDepartment());
        course.setFaculty(courseDetails.getFaculty());

        return courseRepository.save(course);
    }

    // Delete a course by its ID
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        courseRepository.delete(course);
    }
}
