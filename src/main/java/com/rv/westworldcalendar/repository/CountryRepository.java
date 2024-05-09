package com.rv.westworldcalendar.repository;

import com.rv.westworldcalendar.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
