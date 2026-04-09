package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequest;
import com.example.schedule.dto.ScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

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
}
