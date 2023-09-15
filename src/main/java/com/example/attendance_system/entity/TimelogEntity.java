package com.example.attendance_system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("timelogs")
public record TimelogEntity (
    @Id Long id,
    Long userId,
    LocalDateTime startWork,
    LocalDateTime finishWork,
    long totalTime
) {
}
