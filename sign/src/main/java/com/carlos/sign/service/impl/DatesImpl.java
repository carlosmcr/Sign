package com.carlos.sign.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.sign.model.Dates;
import com.carlos.sign.repository.DatesRepository;
import com.carlos.sign.service.DatesService;

@Component
public class DatesImpl implements DatesService {

	@Autowired
	DatesRepository datesRepository;

	@Override
	public String[] read(String fileName) {	
		String dates[] = new String[this.datesRepository.findAll().size()];
		dates = this.datesRepository.findAll().toArray(dates);
		return dates;
	}

	@Override
	public void write(String fileName, String[] dates) {
		//this.datesRepository.deleteAll();
		GregorianCalendar calendar1 = new GregorianCalendar(2019,5,5);
		
		System.out.println(this.datesRepository.findByCalendarAndState(calendar1, "PAUSE")); 
		for (String date : dates) {
			String day = date.substring(0,3);
			String month = date.substring(4,7);
			String numberDay = date.substring(8,10);
			String year = date.substring(11,15);
			String hour = date.substring(16,18);
			String minute = date.substring(19,21);
			String second = date.substring(22,24);
			String state = date.substring(69);
			int numberMonth = 0;
			switch (month) {
			case "Jan":
				 numberMonth = 0;
				break;
			case "Feb":
				 numberMonth = 1;
				break;
			case "Mar":
				 numberMonth = 2;
				break;
			case "Apr":
				 numberMonth = 3;
				break;
			case "May":
				 numberMonth = 4;
				break;
			case "Jun":
				 numberMonth = 5;
				break;
			case "Jul":
				 numberMonth = 6;
				break;
			case "Aug":
				 numberMonth = 7;
				break;
			case "Sep":
				 numberMonth = 8;
				break;
			case "Oct":
				 numberMonth = 9;
				break;
			case "Nov":
				 numberMonth = 10;
				break;
			case "Dec":
				 numberMonth = 11;
				break;
			default:
				break;
			}
			GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(year), numberMonth, Integer.parseInt(numberDay), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second));
			Dates d = new Dates();
			d.setState(state);
			d.setCalendar(calendar);
			this.datesRepository.save(d);
			
		}
//		List<Dates> a = this.datesRepository.findAll();
//		for (Dates object : a) {
//			System.out.println(object.toString());
			
		}
			
		

	

//	@Override
//	public String[] read(String fileName) {
//
//		String directory = System.getProperty("user.home");
//		Path path = Paths.get(directory, fileName);
//		String[] dates = null;
//		try {
//			List<String> list = Files.readAllLines(path);
//			dates = new String[list.size()];
//			dates = list.toArray(dates);
//		} catch (IOException e) {
//
//		}
//
//		return dates;
//	}
//
//	@Override
//	public void write(String fileName, String[] dates) {
//
//		String directory = System.getProperty("user.home");
//		Path path = Paths.get(directory, fileName);
//
//		try {
//			Files.write(path, "".getBytes(), StandardOpenOption.DELETE_ON_CLOSE);
//			if (!Files.exists(path)) {
//				Files.write(path, "".getBytes(), StandardOpenOption.CREATE);
//			}
//			for (String day : dates) {
//				String content = day + System.lineSeparator();
//				Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
//			}
//		} catch (IOException e) {
//
//		}
//	}
	

}
