package com.rv.westworldcalendar.controllers;

import com.rv.westworldcalendar.entity.Country;
import com.rv.westworldcalendar.entity.Holiday;
import com.rv.westworldcalendar.service.CountryService;
import com.rv.westworldcalendar.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getCountry/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Integer id){

        return ResponseEntity.ok(countryService.getCountry(id));

    }

    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){

        return ResponseEntity.ok(countryService.addCountry(country));

    }

    @GetMapping("/getHolidays")
    public ResponseEntity<List<Holiday>> getHoldiayList(){

        return ResponseEntity.ok(holidayService.getHolidaysList());

    }

    @GetMapping("/getHoliday/{id}")
    public ResponseEntity<Holiday> getHoliday(@PathVariable Integer id){

        return ResponseEntity.ok(holidayService.getHoliday(id));

    }

    @PostMapping("/addHoliday")
    public ResponseEntity<Holiday> addHoliday(@RequestBody Holiday holiday){

        return ResponseEntity.ok(holidayService.addHoliday(holiday));

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
