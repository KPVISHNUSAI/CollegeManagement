package com.example.collegeDirectory.controller;

import com.example.collegeDirectory.entity.*;
import com.example.collegeDirectory.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Retrieve a student profile
    @GetMapping("/student/{userId}")
    public ResponseEntity<StudentProfile> getStudentProfile(@PathVariable Long userId) {
        StudentProfile profile = profileService.getStudentProfile(userId);
        return ResponseEntity.ok(profile);
    }

    // Retrieve a faculty profile
    @GetMapping("/faculty/{userId}")
    public ResponseEntity<FacultyProfile> getFacultyProfile(@PathVariable Long userId) {
        FacultyProfile profile = profileService.getFacultyProfile(userId);
        return ResponseEntity.ok(profile);
    }

    // Retrieve an administrator profile
    @GetMapping("/admin/{userId}")
    public ResponseEntity<AdministratorProfile> getAdminProfile(@PathVariable Long userId) {
        AdministratorProfile profile = profileService.getAdminProfile(userId);
        return ResponseEntity.ok(profile);
    }

    // Create or update a student profile
    @PostMapping("/student")
    public ResponseEntity<StudentProfile> saveStudentProfile(@RequestBody StudentProfile studentProfile) {
        StudentProfile savedProfile = profileService.saveStudentProfile(studentProfile);
        return ResponseEntity.ok(savedProfile);
    }

    // Create or update a faculty profile
    @PostMapping("/faculty")
    public ResponseEntity<FacultyProfile> saveFacultyProfile(@RequestBody FacultyProfile facultyProfile) {
        FacultyProfile savedProfile = profileService.saveFacultyProfile(facultyProfile);
        return ResponseEntity.ok(savedProfile);
    }

    // Create or update an administrator profile
    @PostMapping("/admin")
    public ResponseEntity<AdministratorProfile> saveAdminProfile(@RequestBody AdministratorProfile adminProfile) {
        AdministratorProfile savedProfile = profileService.saveAdminProfile(adminProfile);
        return ResponseEntity.ok(savedProfile);
    }

    // Delete a student profile
    @DeleteMapping("/student/{userId}")
    public ResponseEntity<Void> deleteStudentProfile(@PathVariable Long userId) {
        profileService.deleteStudentProfile(userId);
        return ResponseEntity.noContent().build();
    }

    // Delete a faculty profile
    @DeleteMapping("/faculty/{userId}")
    public ResponseEntity<Void> deleteFacultyProfile(@PathVariable Long userId) {
        profileService.deleteFacultyProfile(userId);
        return ResponseEntity.noContent().build();
    }

    // Delete an administrator profile
    @DeleteMapping("/admin/{userId}")
    public ResponseEntity<Void> deleteAdminProfile(@PathVariable Long userId) {
        profileService.deleteAdminProfile(userId);
        return ResponseEntity.noContent().build();
    }
}
