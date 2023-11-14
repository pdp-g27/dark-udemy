package com.example.darktime.user.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
}
