package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleCommentResponse {
    private String comment;
    private String name;
    private LocalDateTime date;

    public ScheduleCommentResponse(String comment, String name, LocalDateTime date){
        this.comment = comment;
        this.name = name;
        this.date = date;
    }
}
