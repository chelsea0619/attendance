package com.example.attendance_system.repository;

import com.example.attendance_system.entity.AttendanceEntity;
import com.example.attendance_system.entity.TimelogEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;

public interface TimelogRepository extends ListCrudRepository<TimelogEntity, Long> {

    TimelogEntity getByUserId(long userId);
    @Modifying
    @Query("UPDATE timelogs SET finish_work = :finishWork,total_time =:totalTime WHERE user_id = :userId")
    void updateLeaveTimeById(Long userId, LocalDateTime finishWork,long totalTime);

}
