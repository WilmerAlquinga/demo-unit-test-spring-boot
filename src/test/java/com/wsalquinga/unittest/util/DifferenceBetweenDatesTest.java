package com.wsalquinga.unittest.util;

import java.time.Period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DifferenceBetweenDatesTest {
	
	@Autowired
	private DifferenceBetweenDates differenceBetweenDates;

	@Test
	void calculateYearsOfIndependence() {
		this.differenceBetweenDates = new DifferenceBetweenDates();
		String independenceDate = "24/05/1822";
		
		Period result = this.differenceBetweenDates.calculateYearsOfIndependence(independenceDate);

		Assertions.assertEquals(201, result.getYears());
		Assertions.assertEquals(3, result.getMonths());
		Assertions.assertEquals(2, result.getDays());
	}
}
