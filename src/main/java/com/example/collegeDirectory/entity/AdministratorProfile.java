package com.example.collegeDirectory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "administrator_profiles")
public class AdministratorProfile {

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

    // Constructors
    public AdministratorProfile() {}

    public AdministratorProfile(User user, String photo, Department department) {
        this.user = user;
        this.photo = photo;
        this.department = department;
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
}
