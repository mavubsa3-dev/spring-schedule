package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String content;
    private String password;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    public Schedule(String name, String title, String content, String password){
        this.name = name;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public void update(String name, String title){
        this.name = name;
        this.title = title;
    }
}
