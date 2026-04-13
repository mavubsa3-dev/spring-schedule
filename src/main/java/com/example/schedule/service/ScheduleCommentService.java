package com.example.schedule.service;

import com.example.schedule.dto.ScheduleCommentRequest;
import com.example.schedule.dto.ScheduleCommentResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.ScheduleComment;
import com.example.schedule.repository.ScheduleCommentRepository;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleCommentService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleCommentRepository scheduleCommentRepository;

    @Transactional
    public ScheduleCommentResponse addComments(Long scheduleId, ScheduleCommentRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        long commentCount = scheduleCommentRepository.countByScheduleId(scheduleId);
        if(commentCount >= 10){
            throw new IllegalStateException("댓글은 10개까지만 작성할 수 있습니다.");
        }
        ScheduleComment comment = new ScheduleComment(
                request.getComment(),
                request.getName(),
                request.getPassword(),
                schedule
        );
        ScheduleComment savedComment = scheduleCommentRepository.save(comment);
        return new ScheduleCommentResponse(
                savedComment.getComment(),
                savedComment.getName(),
                savedComment.getDate()
        );
    }
}
