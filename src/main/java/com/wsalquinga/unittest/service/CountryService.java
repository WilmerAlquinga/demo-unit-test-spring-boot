package com.wsalquinga.unittest.service;

import com.wsalquinga.unittest.dto.CountryDto;

public interface CountryService {
	CountryDto getCountryByIsoCode(String isoCode);
}
