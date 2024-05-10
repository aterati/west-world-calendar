package com.rv.westworldcalendar.service;

import com.rv.westworldcalendar.entity.Country;
import com.rv.westworldcalendar.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Mock
    CountryRepository countryRepository;

    @InjectMocks
    CountryService countryService;

    Country country = new Country(1, "USA","US","America", null);

    @Test
    public void testGetCountry(){
        given(countryRepository.findById(1)).willReturn(Optional.of(country));
        Country responseCountry = countryService.getCountry(1);
        assertThat(country.getCountryName()).isEqualTo(responseCountry.getCountryName());
    }

    @Test
    public void testGetCountriesList(){
        given(countryRepository.findAll()).willReturn(List.of(country));
        List<Country> responseList = countryService.getCountriesList();
        assertThat(responseList.get(0).getCountryName()).isEqualTo(country.getCountryName());
    }

    @Test
    public void testAddCountry(){
        given(countryRepository.save(country)).willReturn(country);
        Country responseCountry = countryService.addCountry(country);
        assertThat(responseCountry.getCountryName()).isEqualTo(country.getCountryName());
    }
}
