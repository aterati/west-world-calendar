package com.rv.westworldcalendar.controllers;

import com.rv.westworldcalendar.enitity.Country;
import com.rv.westworldcalendar.enitity.Holiday;
import com.rv.westworldcalendar.service.CountryService;
import com.rv.westworldcalendar.service.HolidayService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class westRestController {

    @Autowired
    CountryService countryService;

    @Autowired
    HolidayService holidayService;

    @GetMapping("/getCountries")
    public ResponseEntity<List<Country>> getCountryList(){

              return ResponseEntity.ok(countryService.getCountriesList());

    }

    @PostMapping("/addCountry")
    public ResponseEntity<String> addCountry(@RequestBody Country country){

        countryService.addCountry(country);
        return ResponseEntity.ok("Saved Country successfully.");
    }

    @GetMapping("/getHolidays")
    public ResponseEntity<List<Holiday>> getHoldiayList(){

        return ResponseEntity.ok(holidayService.getHolidaysList());

    }

    @PostMapping("/addHoliday")
    public ResponseEntity<String> addHoliday(@RequestBody Holiday holiday){

        holidayService.addHoliday(holiday);
        return ResponseEntity.ok("Saved Country successfully.");
    }

    @PutMapping("/updateCountry/{id}")
    public ResponseEntity<String> updateCountry(@RequestBody Country newCountry,@PathVariable Integer id){

       Country country = (countryService.getCountry(id));
        if(country!=null){
            country.setCountryCode(newCountry.getCountryCode());
            country.setCountryName(newCountry.getCountryName());
            country.setDescription(newCountry.getDescription());
            countryService.addCountry(country);
        }
        else{
            newCountry.setCountryId(id);
            countryService.addCountry(newCountry);
        }
        return ResponseEntity.ok("Country updated successfully.");
    }

    @PutMapping("/updateHoliday/{id}")
    public ResponseEntity<String> updateHoliday(@RequestBody Holiday newHoliday,@PathVariable Integer id){

        Holiday holiday = (holidayService.getHoliday(id));
        if(holiday!=null){
            holiday.setName(newHoliday.getName());
            holiday.setDate(newHoliday.getDate());
            holiday.setDescription(newHoliday.getDescription());
            holidayService.addHoliday(holiday);
        }
        else{
            newHoliday.setCountryId(id);
            holidayService.addHoliday(holiday);
        }
        return ResponseEntity.ok("Holiday updated successfully.");
    }


}
