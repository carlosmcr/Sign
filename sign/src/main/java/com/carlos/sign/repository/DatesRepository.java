package com.carlos.sign.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carlos.sign.model.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Integer>{

	public Dates findBydayOfyearAndState(int day, String state);
	
	public List<Dates> findBydayOfyear(int day);
	
	@Query(value = "SELECT * FROM DATES WHERE STATE LIKE 'START'", nativeQuery=true)
	public List<Dates>  findDistinctdayOfyear();
	
	@Query(value = "SELECT * FROM DATES ORDER BY DAY_OFYEAR ASC", nativeQuery=true)
	public List<Dates>  findAllBydayOfyear();
	
}
