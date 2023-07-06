package com.wsalquinga.unittest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsalquinga.unittest.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	Optional<Country> findByIsoCode(String isoCode);
}
