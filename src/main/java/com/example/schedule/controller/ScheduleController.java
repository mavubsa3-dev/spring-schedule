package com.example.schedule.controller;

import com.example.schedule.dto.*;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<AddScheduleResponse> createSchedule(@RequestBody AddScheduleRequest request){
        AddScheduleResponse result = scheduleService.addSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<CheckOneScheduleResponse> getOneSchedule(@PathVariable Long scheduleId){
        CheckOneScheduleResponse result = scheduleService.getOneSchedule(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<CheckAllScheduleResponse>> getSchedule(@RequestParam(required = false) String userName){
        List<CheckAllScheduleResponse> result = scheduleService.getSchedule(userName);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequest request){
        UpdateScheduleResponse result = scheduleService.updateSchedule(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId, @RequestBody String password){
        scheduleService.deleteSchedule(scheduleId, password);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
