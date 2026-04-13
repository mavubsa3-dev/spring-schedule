package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.ScheduleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface ScheduleCommentRepository extends JpaRepository<ScheduleComment, Long> {
    public boolean countById(Long scheduleId);
}
