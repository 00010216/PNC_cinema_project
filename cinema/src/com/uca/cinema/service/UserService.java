package com.uca.cinema.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.repositories.CountryRepository;
import com.uca.cinema.repositories.MunicipalityRepository;
import com.uca.cinema.repositories.UserRepository;

@Service
public class UserService implements UserInterface{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MunicipalityRepository municipalityRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public void create(CUser user, String countryId, String municipalityId) {				
		user.setCountry(countryRepository.findById(Integer.valueOf(countryId)).get());
		user.setMunicipality(municipalityRepository.findById(Integer.valueOf(municipalityId)).get());
		user.setBalance(BigDecimal.valueOf(20).movePointLeft(2));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = new Date();
			
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
			user.setCreatedDate(df.parse(modifiedDate ));
			
		} catch (ParseException e) {
 
			e.printStackTrace();
		}
		
		
		userRepository.save(user);
	}

	@Override
	public void update(CUser user, String countryId, String municipalityId) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

}
