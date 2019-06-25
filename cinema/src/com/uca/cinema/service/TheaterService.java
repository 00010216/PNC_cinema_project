package com.uca.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
			theater.setCreatedDate(df.parse(modifiedDate ));
			theater.setCreatedBy(1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
