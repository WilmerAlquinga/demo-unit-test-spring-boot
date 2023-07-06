package com.wsalquinga.unittest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryDto {

	private String countryName;

	private String countryCapital;

	private String countryIndependenceDate;

	private Integer yearsOfIndependency;

	private Integer monthsOfIndependency;

	private Integer daysOfIndependency;

}
