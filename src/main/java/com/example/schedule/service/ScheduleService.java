package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequest;
import com.example.schedule.dto.ScheduleResponse;
import com.example.schedule.dto.UpdateScheduleRequest;
import com.example.schedule.dto.UpdateScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public ScheduleResponse getOneSchedule(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () ->  new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return new ScheduleResponse(schedule.getName(),
                                    schedule.getTitle(),
                                    schedule.getContent(),
                                    schedule.getDate());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> getSchedule(String userName){
        List<Schedule> scheduleList;
        if(!userName.isEmpty()){
            scheduleList = scheduleRepository.findAllByNameOrderByDateDesc(userName);
        }else{
            scheduleList = scheduleRepository.findAllByOrderByDateDesc();
        }
        List<ScheduleResponse> scheduleResponseList = new ArrayList<>();
        for(int i=0; i<scheduleList.size(); i++){
            Schedule schedule = scheduleList.get(i);
            ScheduleResponse scheduleResponse = new ScheduleResponse(schedule.getName(),
                                                                     schedule.getTitle(),
                                                                     schedule.getContent(),
                                                                     schedule.getDate());
            scheduleResponseList.add(scheduleResponse);
        }
        return scheduleResponseList;
    }

    @Transactional
    public UpdateScheduleResponse updateSchedule(Long scheduleId, UpdateScheduleRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () ->  new IllegalStateException("존재하지 않는 일정입니다.")
        );
        schedule.update(request.getName(), request.getTitle());
        return new UpdateScheduleResponse(schedule.getName(),
                                          schedule.getTitle(),
                                          schedule.getContent(),
                                          schedule.getDate());
    }


}
