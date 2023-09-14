package com.example.attendance_system.controller;

import com.example.attendance_system.entity.AttendanceEntity;
import com.example.attendance_system.model.RegisterBody;
import com.example.attendance_system.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }

    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signup(@RequestBody RegisterBody body) {
        attendanceService.signup(body.email(),body.firstName(), body.lastName());
    }


}
