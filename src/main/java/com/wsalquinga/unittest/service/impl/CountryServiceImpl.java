package com.wsalquinga.unittest.service.impl;

import java.time.Period;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wsalquinga.unittest.dto.CountryDto;
import com.wsalquinga.unittest.model.Country;
import com.wsalquinga.unittest.repository.CountryRepository;
import com.wsalquinga.unittest.service.CountryService;
import com.wsalquinga.unittest.util.DifferenceBetweenDates;

@Service
public class CountryServiceImpl implements CountryService {
	private CountryRepository countryRepository;
	private DifferenceBetweenDates differenceBetweenDates;

	public CountryServiceImpl(CountryRepository countryRepository, DifferenceBetweenDates differenceBetweenDates) {
		this.countryRepository = countryRepository;
		this.differenceBetweenDates = differenceBetweenDates;
	}

	@Override
	public CountryDto getCountryByIsoCode(String isoCode) {
		Optional<Country> countryOpt = this.countryRepository.findByIsoCode(isoCode);
		if (countryOpt.isEmpty()) {
			return null;
		}
		Country country = countryOpt.get();
		Period period = this.differenceBetweenDates.calculateYearsOfIndependency(country.getCountryIndependenceDate());
		return CountryDto.builder()
				.countryName(country.getCountryName())
				.countryCapital(country.getCountryCapital())
				.countryIndependenceDate(country.getCountryIndependenceDate())
				.daysOfIndependency(period.getDays())
				.monthsOfIndependency(period.getMonths())
				.yearsOfIndependency(period.getYears())
				.build();
	}

}
