package com.wsalquinga.unittest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wsalquinga.unittest.dto.CountryDto;
import com.wsalquinga.unittest.service.CountryService;

@RestController()
public class CountryController {
	private final CountryService countryService;

	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping(path = "/country/{isoCode}")
	public ResponseEntity<CountryDto> getByIsoCode(@PathVariable("isoCode") String isoCode) {
		return ResponseEntity.ok(this.countryService.getCountryByIsoCode(isoCode));
	}
}
