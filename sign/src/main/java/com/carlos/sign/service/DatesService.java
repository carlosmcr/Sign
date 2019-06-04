package com.carlos.sign.service;


import org.springframework.stereotype.Service;

import com.carlos.sign.model.Dates;


@Service
public interface DatesService {


	
	public String[] read(String fileName);
	
	public void updateAll( String[] dates);
	
	public void updateOne(String[] days);




}
