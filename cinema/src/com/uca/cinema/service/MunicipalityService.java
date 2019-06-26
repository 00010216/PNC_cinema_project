package com.uca.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.Municipality;
import com.uca.cinema.repositories.MunicipalityRepository;


@Service
public class MunicipalityService implements MunicipalityInterface{

	@Autowired
	MunicipalityRepository municipalityRepository;
	
	@Override
	public List<Municipality> findAll() {
		// TODO Auto-generated method stub
		return municipalityRepository.findAll();
	}

}
