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
import com.carlos.sign.util.Util;

@Component
public class DatesImpl implements DatesService {

	@Autowired
	DatesRepository datesRepository;

	@Autowired
	Util util;

	@Override
	public String[] read(String fileName) {
		String dates[] = new String[this.datesRepository.findAll().size()];
		dates = this.datesRepository.findAll().toArray(dates);
		return dates;
	}

	@Override
	public void updateAll(String[] dates) {

		for (String date : dates) {
			System.out.println(date);
			String day = date.substring(0, 3);
			String month = date.substring(4, 7);
			String numberDay = date.substring(8, 10);
			String year = date.substring(11, 15);
			String hour = date.substring(16, 18);
			String minute = date.substring(19, 21);
			String second = date.substring(22, 24);
			String state = date.substring(69);
			int numberMonth = this.util.getMonth(month);

			GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(year), numberMonth,
					Integer.parseInt(numberDay), Integer.parseInt(hour), Integer.parseInt(minute),
					Integer.parseInt(second));
			Dates d = new Dates();
			d.setState(state);
			d.setCalendar(calendar);
			d.setDayOfyear(calendar.get(Calendar.DAY_OF_YEAR));
			this.datesRepository.save(d);

		}

	}

	@Override
	public void updateOne(String[] days) {
		String dayOfyear = days[0].substring(days[0].indexOf("_") + 1);
 		List<Dates> dateList = this.datesRepository.findBydayOfyear(Integer.parseInt(dayOfyear));
		String[] dates = new String[dateList.size()];
		String state = "";
		int id;
		for (int i = 0; i < dateList.size(); i++) {
			dates[i] = dateList.get(i).getCalendar().getTime().toString();
			state = dateList.get(i).getState();
			id = dateList.get(i).getIdDate();

			String day = days[i].substring(0, 3);
			String month = days[i].substring(4, 7);
			String numberDay = days[i].substring(8, 10);
			String year = days[i].substring(11, 15);
			String hour = days[i].substring(16, 18);
			String minute = days[i].substring(19, 21);
			String second = days[i].substring(22, 24);

			int numberMonth = this.util.getMonth(month);

			GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(year), numberMonth,
					Integer.parseInt(numberDay), Integer.parseInt(hour), Integer.parseInt(minute),
					Integer.parseInt(second));

			Dates d = this.datesRepository.findById(id).orElse(null);
			d.setCalendar(calendar);
			this.datesRepository.save(d);

		}
	}

}
