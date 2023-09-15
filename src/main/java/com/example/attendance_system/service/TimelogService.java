package com.example.attendance_system.service;

import com.example.attendance_system.entity.TimelogEntity;

import com.example.attendance_system.repository.TimelogRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimelogService {
    private final TimelogRepository timelogRepository;

    //private final TestRepository testRepository;

    public TimelogService(TimelogRepository timelogRepository) {

        this.timelogRepository = timelogRepository;


    }

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void startwork(long userId) {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(date);
        LocalDateTime startTime = LocalDateTime.now();
        TimelogEntity newtimelogEntity = new TimelogEntity(null,userId,startTime,null,0L);
        timelogRepository.save(newtimelogEntity);
    }

    public void finishwork(long userId) {
        TimelogEntity timelogEntity =  timelogRepository.getByUserId(userId);
        LocalDateTime startTime =  timelogEntity.startWork();
        LocalDateTime leaveTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime,leaveTime);
        long totaltime = duration.getSeconds(); // 计算时间差（单位：秒）
        timelogRepository.updateLeaveTimeById(userId, leaveTime,totaltime);

    }
//    public void summary(long userId){
//       SummaryEntity summaryentityfind = summaryRepository.findByUserId(userId);
//        TimelogEntity timelogEntity =  timelogRepository.getByUserId(userId);
//        String startTime =  timelogEntity.startWork();
//        String leaveTime =  timelogEntity.finishWork();
//
//        LocalDateTime startTimeLDT = LocalDateTime.parse(startTime, df);
//        LocalDateTime leaveTimeLDT = LocalDateTime.parse(leaveTime, df);
//        Duration duration = Duration.between(startTimeLDT,leaveTimeLDT);
//        long diffSeconds = duration.getSeconds(); // 计算时间差（单位：秒）
//
//       if(summaryentityfind == null){
//           SummaryEntity summaryentity = new SummaryEntity(null,userId,diffSeconds);
//           summaryRepository.save(summaryentity);
//       }else{
//           summaryRepository.updateTimeDifferByUserId(userId,diffSeconds);
//       }
//
//    }

}
