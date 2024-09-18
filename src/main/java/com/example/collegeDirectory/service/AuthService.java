package com.example.collegeDirectory.service;

import com.example.collegeDirectory.dto.AuthRequestDTO;
import com.example.collegeDirectory.dto.AuthResponseDTO;
import com.example.collegeDirectory.dto.RegisterRequestDTO;
import com.example.collegeDirectory.entity.User;
import com.example.collegeDirectory.entity.Role;
import com.example.collegeDirectory.exception.CustomException;
import com.example.collegeDirectory.repository.UserRepository;
import com.example.collegeDirectory.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponseDTO login(AuthRequestDTO request) {
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new CustomException("User not found"));

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user);
            return new AuthResponseDTO(token);
        } else {
            throw new CustomException("Invalid credentials");
        }
    }

    public void register(RegisterRequestDTO request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setRole(Role.valueOf(request.getRole().toUpperCase())); // Convert string to Role enum

        userRepository.save(user);
    }
}
