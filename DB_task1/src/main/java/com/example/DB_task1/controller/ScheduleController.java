package com.example.DB_task1.controller;

import com.example.DB_task1.model.Schedule;
import com.example.DB_task1.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/tests")
    public ResponseEntity<List<Schedule>> getTests(){
        return ResponseEntity.ok(this.scheduleRepository.findAllByRowIDAndUserID(2L, 2L));
    }
}
