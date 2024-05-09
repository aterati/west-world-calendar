package com.rv.westworldcalendar.service;

import com.rv.westworldcalendar.entity.Country;
import com.rv.westworldcalendar.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WestRestControllerTest {

    @LocalServerPort
    Integer localPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    CountryRepository countryRepository;

    final static String LOCAL_HOST = "http://localhost:";
    Country country = new Country(1, "USA","US","United States Of America",null);


    @BeforeEach
    public void loadCountry(){
        countryRepository.deleteAll();
        countryRepository.save(country);
    }

    @Test
    public void testAddCountry(){
        ResponseEntity<Country> responseEntity = this.testRestTemplate.postForEntity(LOCAL_HOST + localPort + "/addCountry",country, Country.class);
        Country responseCountry = responseEntity.getBody();
        assert responseCountry != null;
        assertThat(responseCountry.getCountryName()).isEqualTo(country.getCountryName());
    }

    @Test
    public void testGetCountries(){
        ResponseEntity<List> responseEntity = this.testRestTemplate.getForEntity(LOCAL_HOST+ localPort + "/getCountries", List.class);
        List countryList = responseEntity.getBody();
        assertThat(countryList).isNotEmpty();
        assertThat(((HashMap<String,String>)countryList.get(0)).get("countryName")).isEqualTo(country.getCountryName());
    }

    @Test
    public void testUpdateCountry(){
        country.setCountryName("Canada");
        int id = countryRepository.findAll().get(0).getCountryId();
        this.testRestTemplate.put(LOCAL_HOST+ localPort + "/updateCountry/"+id, country);
        Country responseCountry = this.testRestTemplate.getForEntity( LOCAL_HOST+localPort+"/getCountry/"+id, Country.class).getBody();
        assert responseCountry != null;
        assertThat(responseCountry.getCountryName()).isEqualTo(country.getCountryName());
    }



}
