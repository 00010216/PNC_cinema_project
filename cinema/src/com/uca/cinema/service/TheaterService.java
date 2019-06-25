package com.uca.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.Theater;
import com.uca.cinema.repositories.TheaterRepository;

@Service
public class TheaterService implements TheaterInterface{

	@Autowired
	TheaterRepository theaterRepository;
	
	@Override
	public List<Theater> getAll() {
		// TODO Auto-generated method stub
		return theaterRepository.findAll();
	}

	@Override
	public Theater getOne(Integer id) {
		// TODO Auto-generated method stub
		return theaterRepository.getOne(id);
	}

	@Override
	public void create(Theater theater) {		
		theaterRepository.save(theater);
	}

	@Override
	public void update(Theater theater) {
		// TODO Auto-generated method stub
		theaterRepository.save(theater);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		theaterRepository.delete(id);
		
	}
	

}
