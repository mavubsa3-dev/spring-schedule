package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class ScheduleRequest {
    private String name;
    private String title;
    private String content;
    private String password;

    public ScheduleRequest(String name, String title, String content, String password){
        this.name = name;
        this.title = title;
        this.content = content;
        this.password = password;
    }
}
