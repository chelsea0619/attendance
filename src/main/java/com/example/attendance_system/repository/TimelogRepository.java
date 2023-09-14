package com.example.attendance_system.repository;

import com.example.attendance_system.entity.AttendanceEntity;
import com.example.attendance_system.entity.TimelogEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface TimelogRepository extends ListCrudRepository<TimelogEntity, Long> {

    TimelogEntity getByUserId(long userId);
    @Modifying
    @Query("UPDATE timelogs SET finish_work = :finishWork WHERE user_id = :userId")
    void updateTimeById(Long userId, String finishWork);

}
