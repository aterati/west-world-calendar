package com.rv.westworldcalendar.service;

import com.rv.westworldcalendar.entity.Holiday;
import com.rv.westworldcalendar.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    @Autowired
    HolidayRepository holidayRepository;

    public Holiday getHoliday(Integer id){

        return holidayRepository.findById(id).get();
    }

    public List<Holiday> getHolidaysList(){

        return holidayRepository.findAll();
    }

    public Holiday addHoliday(Holiday holiday){
        return holidayRepository.save(holiday);
    }
 }
