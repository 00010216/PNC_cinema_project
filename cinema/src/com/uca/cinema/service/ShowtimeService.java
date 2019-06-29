package com.uca.cinema.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cinema.domain.Showtime;
import com.uca.cinema.dto.ShowtimeDTO;

public interface ShowtimeService {
	
	public List<Showtime> findAll() throws DataAccessException;
	
	public ShowtimeDTO findOne(Integer id) throws DataAccessException;
	
	public Showtime findById(Integer id) throws DataAccessException;
	
	public Showtime save(ShowtimeDTO sh) throws DataAccessException, ParseException;
	
	public boolean isAvailable(ShowtimeDTO sh) throws DataAccessException;
	
	public void changeStatus(String theater_id, boolean status) throws DataAccessException;
}
