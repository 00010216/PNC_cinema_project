package com.uca.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.Country;
import com.uca.cinema.repositories.CountryRepository;

@Service
public class CountryService implements CountryInterface{

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

}
