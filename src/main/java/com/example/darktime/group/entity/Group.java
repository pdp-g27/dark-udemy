package com.example.darktime.group.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "`group`")
public class Group {
    @Id
    private UUID uuid;
    private String name;
    private UUID mentorId;
    private LocalDate startDate;
    @Enumerated
    private GroupType groupType;
    @Enumerated
    private GroupStatus groupStatus;

}
