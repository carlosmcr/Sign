package com.carlos.sign.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.sign.model.Dates;

@Service
public interface DatesService {

	public String[] getAll();

	public void updateAll(String[] dates);
	
	public List<Dates> getlist();

}
