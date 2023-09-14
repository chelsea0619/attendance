package com.example.attendance_system.repository;

import com.example.attendance_system.entity.AttendanceEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface AttendanceRepository extends ListCrudRepository<AttendanceEntity, Long> {
    AttendanceEntity findByEmail(String email);
}
