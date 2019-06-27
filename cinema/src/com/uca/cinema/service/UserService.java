package com.uca.cinema.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		user.setCountry(countryRepository.findById(Integer.valueOf(countryId)).get());
		user.setMunicipality(municipalityRepository.findById(Integer.valueOf(municipalityId)).get());
		user.setBalance(BigDecimal.valueOf(20).movePointLeft(0));
		user.setStatus(false);			
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
	public void update(CUser user) {
		// TODO Auto-generated method stub
		CUser usuario = userRepository.findById(user.getIdUser()).get();
		usuario.setStatus(user.getStatus());
		userRepository.save(usuario);
		
	}

	@Override
	public List<CUser> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public CUser findOne(Integer user_id) {
		// TODO Auto-generated method stub
		return userRepository.findById(user_id).get();
	}

}
