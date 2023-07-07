package com.wsalquinga.unittest.util;

import java.time.Period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DifferenceBetweenDatesTest {
	
	@Autowired
	private DifferenceBetweenDates differenceBetweenDates;

	@Test
	void calculateYearsOfIndependency() {
		this.differenceBetweenDates = new DifferenceBetweenDates();
		String independencyDate = "24/05/1822";
		
		Period result = this.differenceBetweenDates.calculateYearsOfIndependency(independencyDate);

		Assertions.assertEquals(201, result.getYears());
		Assertions.assertEquals(1, result.getMonths());
		Assertions.assertEquals(12, result.getDays());
	}
}
