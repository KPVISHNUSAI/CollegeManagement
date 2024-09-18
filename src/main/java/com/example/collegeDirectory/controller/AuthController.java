package com.example.collegeDirectory.controller;

import com.example.collegeDirectory.dto.AuthRequestDTO;
import com.example.collegeDirectory.dto.AuthResponseDTO;
import com.example.collegeDirectory.dto.RegisterRequestDTO;
import com.example.collegeDirectory.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        AuthResponseDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO request) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }
}
