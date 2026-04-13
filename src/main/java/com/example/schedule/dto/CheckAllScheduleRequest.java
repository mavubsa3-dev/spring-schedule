package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CheckAllScheduleRequest {
    private String name;
    private String title;
    private String content;
    private String password;
    private LocalDateTime date;
}
