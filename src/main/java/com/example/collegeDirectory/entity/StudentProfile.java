package com.example.collegeDirectory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(nullable = false)
    private String year;
    public StudentProfile() {}

    public StudentProfile(User user, String photo, Department department, String year) {
        this.user = user;
        this.photo = photo;
        this.department = department;
        this.year = year;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

    public String getPhoto() {
        return photo;
    }

    public Department getDepartment() {
        return department;
    }

    public String getYear() {
        return year;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
