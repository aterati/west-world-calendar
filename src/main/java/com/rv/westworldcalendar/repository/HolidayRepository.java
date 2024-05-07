package com.rv.westworldcalendar.repository;

import com.rv.westworldcalendar.enitity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}
