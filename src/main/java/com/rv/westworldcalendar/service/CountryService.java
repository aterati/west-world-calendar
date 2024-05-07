package com.rv.westworldcalendar.service;

import com.rv.westworldcalendar.enitity.Country;
import com.rv.westworldcalendar.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public Country getCountry(Integer id){
        return countryRepository.findById(id).get();
    }

    public List<Country> getCountriesList(){
        return countryRepository.findAll();
    }

    public Country addCountry(Country country){
        return countryRepository.save(country);
    }

//    public Country saveUpdateCountry(Country country)
 }
