package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AddScheduleResponse {
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime date;

    public AddScheduleResponse(String name, String title, String content, LocalDateTime date){
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
