package com.example.attendance_system.service;

import com.example.attendance_system.entity.AttendanceEntity;
import com.example.attendance_system.entity.SummaryEntity;
import com.example.attendance_system.entity.TimelogEntity;
import com.example.attendance_system.repository.AttendanceRepository;
import com.example.attendance_system.repository.SummaryRepository;
import com.example.attendance_system.repository.TimelogRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimelogService {
    private final TimelogRepository timelogRepository;
    private final SummaryRepository summaryRepository;

    public TimelogService(TimelogRepository timelogRepository,SummaryRepository summaryRepository) {

        this.timelogRepository = timelogRepository;
        this.summaryRepository = summaryRepository;
    }

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void startwork(long userId) {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(date);
        LocalDateTime time1 = LocalDateTime.now();
        String localTime = df.format(time1);
        TimelogEntity newtimelogEntity = new TimelogEntity(null,userId,localTime,null);
        timelogRepository.save(newtimelogEntity);
    }

    public void finishwork(long userId) {

        LocalDateTime time2 = LocalDateTime.now();
        String localTime = df.format(time2);
        timelogRepository.updateTimeById(userId, localTime);

    }
    public void summary(long userId){
       SummaryEntity summaryentityfind = summaryRepository.findByUserId(userId);
        TimelogEntity timelogEntity =  timelogRepository.getByUserId(userId);
        String startTime =  timelogEntity.startWork();
        String leaveTime =  timelogEntity.finishWork();

        LocalDateTime startTimeLDT = LocalDateTime.parse(startTime, df);
        LocalDateTime leaveTimeLDT = LocalDateTime.parse(leaveTime, df);
        Duration duration = Duration.between(startTimeLDT,leaveTimeLDT);
        long diffSeconds = duration.getSeconds(); // 计算时间差（单位：秒）

       if(summaryentityfind == null){
           SummaryEntity summaryentity = new SummaryEntity(null,userId,diffSeconds);
           summaryRepository.save(summaryentity);
       }else{
           summaryRepository.updateTimeDifferByUserId(userId,diffSeconds);
       }

    }
}
