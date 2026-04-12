package com.example.schedule.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ScheduleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private String name;
    private String password;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private String date;

    public ScheduleComment(String comment, String name, String password){
        this.comment = comment;
        this.name = name;
        this.password = password;
    }
}
