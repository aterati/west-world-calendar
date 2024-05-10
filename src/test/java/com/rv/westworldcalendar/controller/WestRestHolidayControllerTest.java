package com.rv.westworldcalendar.controller;

import com.rv.westworldcalendar.entity.Country;
import com.rv.westworldcalendar.entity.Holiday;
import com.rv.westworldcalendar.repository.CountryRepository;
import com.rv.westworldcalendar.repository.HolidayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WestRestHolidayControllerTest {

    @LocalServerPort
    Integer localPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    HolidayRepository holidayRepository;

    final static String LOCAL_HOST = "http://localhost:";
    Country country = new Country(1, "USA","US","United States Of America",null);
    Holiday holiday;

    {
        try {
            holiday = new Holiday(1,1, new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"),"new year's eve","new year's eve", country);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void loadData(){
        countryRepository.deleteAll();
        countryRepository.save(country);
        holidayRepository.deleteAll();
        holidayRepository.save(holiday);
    }

    @Test
    public void testAddHoliday(){
        ResponseEntity<Holiday> responseEntity = this.testRestTemplate.postForEntity(LOCAL_HOST + localPort + "/addHoliday",holiday, Holiday.class);
        Holiday responseHoliday = responseEntity.getBody();
        assert responseHoliday != null;
        assertThat(responseHoliday.getName()).isEqualTo(holiday.getName());
    }

    @Test
    public void testGetHolidays(){
        ResponseEntity<List> responseEntity = this.testRestTemplate.getForEntity(LOCAL_HOST+ localPort + "/getHolidays", List.class);
        List holidayList = responseEntity.getBody();
        assertThat(holidayList).isNotEmpty();
        assertThat(((HashMap<String,String>) holidayList.get(0)).get("name")).isEqualTo(holiday.getName());
    }

    @Test
    public void testUpdateHoliday(){
        holiday.setName("Christmas");
        int id = holidayRepository.findAll().get(0).getId();
        this.testRestTemplate.put(LOCAL_HOST+ localPort + "/updateHoliday/"+id, holiday);
        Holiday responseHoliday = this.testRestTemplate.getForEntity( LOCAL_HOST+localPort+"/getHoliday/"+id, Holiday.class).getBody();
        assert responseHoliday != null;
        assertThat(responseHoliday.getName()).isEqualTo(holiday.getName());
    }

}
