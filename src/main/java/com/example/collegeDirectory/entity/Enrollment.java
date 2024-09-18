package com.example.collegeDirectory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentProfile student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Constructors
    public Enrollment() {}

    public Enrollment(StudentProfile student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public StudentProfile getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent(StudentProfile student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
