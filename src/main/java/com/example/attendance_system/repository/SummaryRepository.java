package com.example.attendance_system.repository;

import com.example.attendance_system.entity.AttendanceEntity;
import com.example.attendance_system.entity.SummaryEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface SummaryRepository  extends ListCrudRepository<SummaryEntity, Long> {
    SummaryEntity findByUserId(long userId); //不一定对！
    @Modifying
    @Query("UPDATE summary SET  time_differ = :timeDiffer WHERE user_id = :userId") //这里可能有问题
    void updateTimeDifferByUserId(Long userId, Long timeDiffer);
}
