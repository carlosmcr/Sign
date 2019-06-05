package com.carlos.sign.controller;

import java.util.List;

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
		return new ResponseEntity<String[]>(datesService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/days", method = RequestMethod.POST)
	public ResponseEntity<Void> saveAllDates(@RequestBody String[] days) {
		datesService.updateAll(days);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Dates>> getList() {
		return new ResponseEntity<List<Dates>>(datesService.getlist(), HttpStatus.OK);
	}

}
