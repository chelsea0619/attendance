package com.example.attendance_system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("summary")
public record SummaryEntity (
        @Id Long id,
        Long userId,
        long timeDiffer
){
}
