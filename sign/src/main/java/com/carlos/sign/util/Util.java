package com.carlos.sign.util;

import org.springframework.stereotype.Service;

@Service
public class Util {

	public int getMonth(String month) {

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

		return numberMonth;
	}

}
