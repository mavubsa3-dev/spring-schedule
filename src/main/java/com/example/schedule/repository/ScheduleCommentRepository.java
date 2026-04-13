package com.example.schedule.repository;

import com.example.schedule.dto.CheckAllScheduleResponse;
import com.example.schedule.entity.ScheduleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface ScheduleCommentRepository extends JpaRepository<ScheduleComment, Long> {
    public long countByScheduleId(Long scheduleId);
    public List<ScheduleComment> findAllByScheduleId(Long scheduleId);
}
