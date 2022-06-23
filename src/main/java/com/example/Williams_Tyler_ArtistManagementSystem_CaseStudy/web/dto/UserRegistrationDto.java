package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String role;
}
