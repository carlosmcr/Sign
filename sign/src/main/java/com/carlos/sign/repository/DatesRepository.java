package com.carlos.sign.repository;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.sign.model.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Integer>{

	public Dates findByCalendarAndState(GregorianCalendar calendar, String state);
}
