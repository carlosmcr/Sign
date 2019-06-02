package com.carlos.sign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.sign.model.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Integer>{

}
