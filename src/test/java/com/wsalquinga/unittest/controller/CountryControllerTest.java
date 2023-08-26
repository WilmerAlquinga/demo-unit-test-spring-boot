package com.wsalquinga.unittest.controller;

import com.wsalquinga.unittest.dto.CountryDto;
import com.wsalquinga.unittest.repository.CountryRepository;
import com.wsalquinga.unittest.service.CountryService;
import com.wsalquinga.unittest.service.impl.CountryServiceImpl;
import com.wsalquinga.unittest.util.DifferenceBetweenDates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CountryControllerTest {

    @Autowired
    CountryService countryServiceMock = Mockito.mock(CountryService.class);

    @Autowired
    CountryController countryController = new CountryController(countryServiceMock);

    @BeforeEach
    void setUp() {
        Mockito.when(countryServiceMock.getCountryByIsoCode("EC")).thenReturn(
                CountryDto.builder()
                        .countryName("Ecuador")
                        .countryCapital("Quito")
                        .countryIndependenceDate("24/05/1802")
                        .build()
        );
    }

    @Test
    void getByIsoCode() {
        ResponseEntity<CountryDto> responseDto = countryController.getByIsoCode("EC");
        Assertions.assertEquals("Ecuador", responseDto.getBody().getCountryName());
    }

}