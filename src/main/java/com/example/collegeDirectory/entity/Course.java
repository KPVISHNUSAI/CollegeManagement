package com.example.collegeDirectory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private FacultyProfile faculty;

    // Constructors
    public Course() {}

    public Course(String title, String description, Department department, FacultyProfile faculty) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.faculty = faculty;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Department getDepartment() {
        return department;
    }

    public FacultyProfile getFaculty() {
        return faculty;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setFaculty(FacultyProfile faculty) {
        this.faculty = faculty;
    }
}
