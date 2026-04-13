package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequest;
import com.example.schedule.dto.ScheduleResponse;
import com.example.schedule.dto.UpdateScheduleRequest;
import com.example.schedule.dto.UpdateScheduleResponse;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody ScheduleRequest request){
        ScheduleResponse result = scheduleService.addSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getOneSchedule(@PathVariable Long scheduleId){
        ScheduleResponse result = scheduleService.getOneSchedule(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getSchedule(@RequestParam(required = false) String userName){
        List<ScheduleResponse> result = scheduleService.getSchedule(userName);
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
