package com.carlos.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.sign.model.Dates;
import com.carlos.sign.service.DatesService;

@RestController
public class DateController {

	@Autowired
	DatesService datesService;

	@RequestMapping(value = "/days", method = RequestMethod.GET)
	public ResponseEntity<String[]> getAllDates() {

		String days[] = datesService.read("days");
		return new ResponseEntity<String[]>(days, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/days", method = RequestMethod.POST)
	public ResponseEntity<Void> postAllDates(@RequestBody String[] days) {
		datesService.write("days", days);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}


}
