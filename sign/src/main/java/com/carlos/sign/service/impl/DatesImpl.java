package com.carlos.sign.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

	String dayOfyear = "";
	String day = "";
	String month = "";
	String numberDay = "";
	String year = "";
	String hour = "";
	String minute = "";
	String second = "";
	String state = "";
	int numberMonth = 0;

	@Override
	public String[] getAll() {
		List<Dates> dates = this.datesRepository.findDistinctdayOfyear();
		String calendar[] = new String[dates.size()];
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy, MM , dd");
		
		for (int i = 0; i < calendar.length; i++) {
			fmt.setCalendar(dates.get(i).getCalendar());
			calendar[i] = fmt.format(dates.get(i).getCalendar().getTime());			
		}
		 
		return calendar;
	}

	@Override
	public void updateAll(String[] dates) {

		for (int i = 0; i < dates.length; i++) {
			dayOfyear = dates[i].substring(dates[i].indexOf("_") + 1);

			day = dates[i].substring(0, 3);
			month = dates[i].substring(4, 7);
			numberDay = dates[i].substring(8, 10);
			year = dates[i].substring(11, 15);
			hour = dates[i].substring(16, 18);
			minute = dates[i].substring(19, 21);
			second = dates[i].substring(22, 24);
			state = dates[i].substring(69, dates[i].indexOf("_"));
			numberMonth = this.util.getMonth(month);

			GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(year), numberMonth,
					Integer.parseInt(numberDay), Integer.parseInt(hour), Integer.parseInt(minute),
					Integer.parseInt(second));

			List<Dates> dateList = this.datesRepository.findBydayOfyear(Integer.parseInt(dayOfyear));

			if (dateList.size() == 4) {
				int id = dateList.get(i).getIdDate();
				Dates d = this.datesRepository.findById(id).orElse(null);
				d.setCalendar(calendar);
				this.datesRepository.save(d);
			} else {
				Dates d = new Dates();
				d.setState(state);
				d.setCalendar(calendar);
				d.setDayOfyear(calendar.get(Calendar.DAY_OF_YEAR));
				this.datesRepository.save(d);
			}

		}

	}

	@Override
	public List<Dates> getlist() {
		return this.datesRepository.findAll();		
		//https://stackoverflow.com/questions/44225978/passing-listobject-to-thymeleaf-with-spring-boot
	}

}
