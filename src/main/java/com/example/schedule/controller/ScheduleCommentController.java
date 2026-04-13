package com.example.schedule.controller;

import com.example.schedule.dto.AddScheduleCommentRequest;
import com.example.schedule.dto.AddScheduleCommentResponse;
import com.example.schedule.service.ScheduleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleCommentController {

    private final ScheduleCommentService scheduleCommentService;

    @PostMapping("/{scheduleId}/comments")
    public ResponseEntity<AddScheduleCommentResponse> addComments(@PathVariable Long scheduleId, @RequestBody AddScheduleCommentRequest request){
        AddScheduleCommentResponse result = scheduleCommentService.addComments(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
