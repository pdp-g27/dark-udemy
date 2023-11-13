package com.example.darktime.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "`user`")
@Builder
public class User {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private UserType userType;
    private String phoneNumber;
    private String email;
    private String password;

}
