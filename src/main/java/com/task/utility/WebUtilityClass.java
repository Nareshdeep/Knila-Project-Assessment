package com.task.utility;

import java.time.LocalDate;
import java.time.Period;

public class WebUtilityClass {

	public static int ageCalculator(int year, int month, int date) {

		LocalDate dob = LocalDate.of(year, month, date);
		// obtains the current date from the system clock
		LocalDate curDate = LocalDate.now();
		// calculates the difference betwween two dates
		Period period = Period.between(dob, curDate);
		// prints the differnce in years, months, and days
		int years = period.getYears();
		return years;
	}

	public static double calculateBMI(double weight, double height) {
		double heightM = height / 100;
		return weight / (heightM * heightM);
	}

}
