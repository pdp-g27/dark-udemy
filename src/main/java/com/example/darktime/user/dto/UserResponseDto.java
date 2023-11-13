package com.example.darktime.user.dto;

import com.example.darktime.user.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private UserType userType;
    private String phoneNumber;
    private String email;
    private String password;
}
