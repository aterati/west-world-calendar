package com.rv.westworldcalendar.service;

import com.rv.westworldcalendar.entity.Holiday;
import com.rv.westworldcalendar.repository.HolidayRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class HolidayServiceTest {

    @Mock
    HolidayRepository holidayRepository;

    @InjectMocks
    HolidayService holidayService;

    Holiday holiday = new Holiday(1, 1, new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"),
                                "New Year", "New Year's Eve", null);

    public HolidayServiceTest() throws ParseException {
    }

    @Test
    public void testGetHoliday(){
        given(holidayRepository.findById(1)).willReturn(Optional.of(holiday));
        Holiday responseHoliday = holidayService.getHoliday(1);
        assertThat(responseHoliday.getName()).isEqualTo(holiday.getName());
    }

    @Test
    public void testGetHolidaysList(){
        given(holidayRepository.findAll()).willReturn(List.of(holiday));
        List<Holiday> responseList = holidayService.getHolidaysList();
        assertThat(responseList.get(0).getName()).isEqualTo(holiday.getName());
    }

    @Test
    public void testAddHoliday(){
        given(holidayRepository.save(holiday)).willReturn(holiday);
        Holiday responseHoliday = holidayService.addHoliday(holiday);
        assertThat(responseHoliday.getName()).isEqualTo(holiday.getName());
    }
}
