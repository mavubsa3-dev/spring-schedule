package com.example.schedule.service;

import com.example.schedule.dto.ScheduleCommentRequest;
import com.example.schedule.dto.ScheduleCommentResponse;
import com.example.schedule.entity.ScheduleComment;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleCommentService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleCommentResponse addComments(Long scheduleId, ScheduleCommentRequest request){
        ScheduleComment comment = new ScheduleComment(
                request.getComment(),
                request.getName(),
                request.getPassword()
        );
        ScheduleComment savedComment = scheduleRepository.save(comment);
    }
}
