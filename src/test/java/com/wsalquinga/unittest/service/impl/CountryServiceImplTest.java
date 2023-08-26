package com.wsalquinga.unittest.service.impl;

import com.wsalquinga.unittest.dto.CountryDto;
import com.wsalquinga.unittest.model.Country;
import com.wsalquinga.unittest.repository.CountryRepository;
import com.wsalquinga.unittest.util.DifferenceBetweenDates;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CountryServiceImplTest {

    private CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);

    @Autowired
    private DifferenceBetweenDates differenceBetweenDates = new DifferenceBetweenDates();

    @Autowired
    private CountryServiceImpl countryServiceImpl = new CountryServiceImpl(countryRepositoryMock, differenceBetweenDates);

    @BeforeEach
    void setUp() {
        Country countryMock = new Country();
        countryMock.setCountryId(593L);
        countryMock.setIsoCode("EC");
        countryMock.setCountryName("Ecuador");
        countryMock.setCountryCapital("Quito");
        countryMock.setCountryIndependenceDate("24/05/1802");

        Mockito.when(countryRepositoryMock.findByIsoCode("EC")).thenReturn(Optional.of(countryMock));
    }

    @Test
    void getCountryByIsoCode() {
        CountryDto countryDto = countryServiceImpl.getCountryByIsoCode("EC");
        Assertions.assertEquals("Ecuador", countryDto.getCountryName());
        Assertions.assertEquals("Quito", countryDto.getCountryCapital());
        Assertions.assertEquals("24/05/1802", countryDto.getCountryIndependenceDate());
    }

    @AfterEach
    void tearDown() {}

}