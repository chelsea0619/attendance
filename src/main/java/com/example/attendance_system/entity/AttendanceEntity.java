package com.example.attendance_system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.security.Timestamp;

@Table("attendances")
public record AttendanceEntity(
        @Id Long id,
        String email,
        String firstName,
        String lastName

) {

}