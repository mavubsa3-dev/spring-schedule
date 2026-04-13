package com.example.schedule.dto;

import com.example.schedule.entity.ScheduleComment;
import lombok.Getter;

import java.util.List;
import java.time.LocalDateTime;

@Getter
public class CheckOneScheduleResponse {
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime date;
    private final List<AddScheduleCommentResponse> comments;

    public CheckOneScheduleResponse(String name, String title, String content, LocalDateTime date, List<AddScheduleCommentResponse> comments){
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
        this.comments = comments;
    }
}
