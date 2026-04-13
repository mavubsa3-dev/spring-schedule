package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AddScheduleCommentResponse {
    private final String comment;
    private final String name;
    private final LocalDateTime date;

    public AddScheduleCommentResponse(String comment, String name, LocalDateTime date){
        this.comment = comment;
        this.name = name;
        this.date = date;
    }
}
