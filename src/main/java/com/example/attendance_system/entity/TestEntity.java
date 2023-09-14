package com.example.attendance_system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Duration;
import java.time.LocalDateTime;

@Table("tests")
public record TestEntity (
        @Id Long id,
        LocalDateTime testStart ,
        LocalDateTime testFinish
        //Duration testDuration
){
}
