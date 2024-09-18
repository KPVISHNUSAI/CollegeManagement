package com.example.collegeDirectory.controller;

import com.example.collegeDirectory.dto.CourseDTO;
import com.example.collegeDirectory.entity.Course;
import com.example.collegeDirectory.service.CourseService;
import com.example.collegeDirectory.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Retrieve all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // Retrieve a course by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        try {
            Course course = courseService.getCourseById(id);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Create a new course
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        // Set department and faculty using their IDs, implement a method in service to retrieve them
        // course.setDepartment(departmentService.getDepartmentById(courseDTO.getDepartmentId()));
        // course.setFaculty(facultyService.getFacultyById(courseDTO.getFacultyId()));
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    // Update an existing course
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        try {
            Course courseDetails = new Course();
            courseDetails.setTitle(courseDTO.getTitle());
            courseDetails.setDescription(courseDTO.getDescription());
            // Set department and faculty using their IDs
            // courseDetails.setDepartment(departmentService.getDepartmentById(courseDTO.getDepartmentId()));
            // courseDetails.setFaculty(facultyService.getFacultyById(courseDTO.getFacultyId()));
            Course updatedCourse = courseService.updateCourse(id, courseDetails);
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a course by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
