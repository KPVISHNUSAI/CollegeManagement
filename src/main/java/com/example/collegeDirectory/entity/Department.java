package com.example.collegeDirectory.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "department")
    private Set<StudentProfile> students;

    @OneToMany(mappedBy = "department")
    private Set<FacultyProfile> facultyMembers;

    @OneToMany(mappedBy = "department")
    private Set<AdministratorProfile> administrators;

    @OneToMany(mappedBy = "department")
    private Set<Course> courses;

    // Constructors
    public Department() {}

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<StudentProfile> getStudents() {
        return students;
    }

    public Set<FacultyProfile> getFacultyMembers() {
        return facultyMembers;
    }

    public Set<AdministratorProfile> getAdministrators() {
        return administrators;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStudents(Set<StudentProfile> students) {
        this.students = students;
    }

    public void setFacultyMembers(Set<FacultyProfile> facultyMembers) {
        this.facultyMembers = facultyMembers;
    }

    public void setAdministrators(Set<AdministratorProfile> administrators) {
        this.administrators = administrators;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
