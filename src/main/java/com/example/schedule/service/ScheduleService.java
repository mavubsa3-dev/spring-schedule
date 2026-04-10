package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequest;
import com.example.schedule.dto.ScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponse addSchedule(ScheduleRequest request){
        Schedule schedule = new Schedule(request.getName(),
                                         request.getTitle(),
                                         request.getContent(),
                                         request.getPassword());

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponse(savedSchedule.getName(),
                                    savedSchedule.getTitle(),
                                    savedSchedule.getContent(),
                                    savedSchedule.getDate());
    }

    @Transactional
    public ScheduleResponse getOneSchedule(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () ->  new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return new ScheduleResponse(schedule.getName(),
                                    schedule.getTitle(),
                                    schedule.getContent(),
                                    schedule.getDate());
    }
}
