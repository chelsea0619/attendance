package com.example.attendance_system.service;

import com.example.attendance_system.entity.AttendanceEntity;
import com.example.attendance_system.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    public AttendanceService( AttendanceRepository attendanceRepository){
        this.attendanceRepository = attendanceRepository;
    }
    public void signup(String email,String firstName, String lastName){
        AttendanceEntity newAttendanceEntity = new AttendanceEntity(null,email,firstName,lastName);
        attendanceRepository.save(newAttendanceEntity);
    }
    public AttendanceEntity getAttendanceByEmail(String email){
        return attendanceRepository.findByEmail(email);
    }

}
