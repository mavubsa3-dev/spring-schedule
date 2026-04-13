package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleCommentRequest;
import com.example.schedule.dto.ScheduleCommentResponse;
import com.example.schedule.dto.ScheduleResponse;
import com.example.schedule.service.ScheduleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleCommentController {
    private ScheduleCommentService scheduleCommentService;
    @PostMapping("/{scheduleId}/commentns")
    public ResponseEntity<ScheduleCommentResponse> addComments(@PathVariable Long scheduleId, @RequestBody ScheduleCommentRequest request){
        ScheduleCommentResponse result = scheduleCommentService.addComments(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
