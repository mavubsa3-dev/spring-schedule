package com.example.schedule.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "schedule_comment")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ScheduleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private String name;
    private String password;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    public ScheduleComment(String comment, String name, String password, Schedule schedule){
        this.comment = comment;
        this.name = name;
        this.password = password;
        this.schedule = schedule;
    }
}
