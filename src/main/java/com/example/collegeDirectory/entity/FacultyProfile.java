package com.example.collegeDirectory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty_profiles")
public class FacultyProfile {

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

    @Column(name = "office_hours")
    private String officeHours;

    // Constructors
    public FacultyProfile() {}

    public FacultyProfile(User user, String photo, Department department, String officeHours) {
        this.user = user;
        this.photo = photo;
        this.department = department;
        this.officeHours = officeHours;
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

    public String getOfficeHours() {
        return officeHours;
    }

    // Setters
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

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
}
