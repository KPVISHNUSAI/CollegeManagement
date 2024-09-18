package com.example.collegeDirectory.service;

import com.example.collegeDirectory.entity.*;
import com.example.collegeDirectory.exception.ResourceNotFoundException;
import com.example.collegeDirectory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private AdminProfileRepository adminProfileRepository;

    // Retrieve a student's profile by userId
    public StudentProfile getStudentProfile(Long userId) {
        return studentProfileRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for this user id: " + userId));
    }

    // Retrieve a faculty member's profile by userId
    public FacultyProfile getFacultyProfile(Long userId) {
        return facultyProfileRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty profile not found for this user id: " + userId));
    }

    // Retrieve an administrator's profile by userId
    public AdministratorProfile getAdminProfile(Long userId) {
        return adminProfileRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Administrator profile not found for this user id: " + userId));
    }

    // Create or update student profile
    public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
        Optional<User> user = userRepository.findById(studentProfile.getUser().getId());
        if (!user.isPresent() || user.get().getRole() != Role.STUDENT) {
            throw new ResourceNotFoundException("No student found with this user id.");
        }
        studentProfile.setUser(user.get());
        return studentProfileRepository.save(studentProfile);
    }

    // Create or update faculty profile
    public FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile) {
        Optional<User> user = userRepository.findById(facultyProfile.getUser().getId());
        if (!user.isPresent() || user.get().getRole() != Role.FACULTY_MEMBER) {
            throw new ResourceNotFoundException("No faculty member found with this user id.");
        }
        facultyProfile.setUser(user.get());
        return facultyProfileRepository.save(facultyProfile);
    }

    // Create or update administrator profile
    public AdministratorProfile saveAdminProfile(AdministratorProfile adminProfile) {
        Optional<User> user = userRepository.findById(adminProfile.getUser().getId());
        if (!user.isPresent() || user.get().getRole() != Role.ADMINISTRATOR) {
            throw new ResourceNotFoundException("No administrator found with this user id.");
        }
        adminProfile.setUser(user.get());
        return adminProfileRepository.save(adminProfile);
    }

    // Delete a student profile by userId
    public void deleteStudentProfile(Long userId) {
        StudentProfile studentProfile = getStudentProfile(userId);
        studentProfileRepository.delete(studentProfile);
    }

    // Delete a faculty profile by userId
    public void deleteFacultyProfile(Long userId) {
        FacultyProfile facultyProfile = getFacultyProfile(userId);
        facultyProfileRepository.delete(facultyProfile);
    }

    // Delete an administrator profile by userId
    public void deleteAdminProfile(Long userId) {
        AdministratorProfile adminProfile = getAdminProfile(userId);
        adminProfileRepository.delete(adminProfile);
    }
}
