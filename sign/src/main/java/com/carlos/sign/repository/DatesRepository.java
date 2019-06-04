package com.carlos.sign.repository;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.sign.model.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Integer>{

	public Dates findBydayOfyearAndState(int day, String state);
	
	public List<Dates> findBydayOfyear(int day);

	
}
