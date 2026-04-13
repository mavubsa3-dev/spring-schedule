package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleCommentRequest {
    private String comment;
    private String name;
    private String password;
    private LocalDateTime date;
}
