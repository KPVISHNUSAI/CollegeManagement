package com.example.collegeDirectory.dto;

public class AuthResponseDTO {
    private String token;

    public AuthResponseDTO(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter
    public void setToken(String token) {
        this.token = token;
    }
}
