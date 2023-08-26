package com.wsalquinga.unittest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Long countryId;

	@Column(name = "iso_code")
	private String isoCode;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "country_capital")
	private String countryCapital;

	@Column(name = "country_independence_date")
	private String countryIndependenceDate;

}
