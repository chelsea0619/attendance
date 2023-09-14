package com.example.attendance_system.repository;

import com.example.attendance_system.entity.AttendanceEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface AttendanceRepository extends ListCrudRepository<AttendanceEntity, Long> {
//    @Modifying //specify query的,因为是update操作,所以要加一个!modifying
//    @Query("UPDATE attendances SET finish_work = :finishwork WHERE email = :email")
//    void updateTimeByEmail(String email,String finishwork);
    AttendanceEntity findByEmail(String email);
}
