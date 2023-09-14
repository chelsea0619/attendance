package com.example.attendance_system.controller;

import com.example.attendance_system.entity.AttendanceEntity;
import com.example.attendance_system.model.RegisterBody;
import com.example.attendance_system.service.AttendanceService;
import com.example.attendance_system.service.TimelogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TimelogController {
    private final AttendanceService attendanceService;
    private final TimelogService timelogService;

    public TimelogController(AttendanceService attendanceService,TimelogService timelogService){
        this.attendanceService = attendanceService;
        this.timelogService = timelogService;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @PostMapping("/startwork")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void startwork(@RequestBody RegisterBody body) {
        AttendanceEntity attendance = attendanceService.getAttendanceByEmail(body.email());
        timelogService.startwork(attendance.id());
    }
    @PostMapping("/finishwork")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void finishwork(@RequestBody RegisterBody body) {
        AttendanceEntity attendance = attendanceService.getAttendanceByEmail(body.email());
        timelogService.finishwork(attendance.id());
    }

    @PostMapping("/summary")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void summary(@RequestBody RegisterBody body) {
        AttendanceEntity attendance = attendanceService.getAttendanceByEmail(body.email());
        timelogService.summary(attendance.id());
    }

}
