package com.uca.cinema.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Movie;

public interface MovieService {
	
	public List<Movie> findAll() throws DataAccessException;
	
	public Movie findOne(Integer id) throws DataAccessException;
	
	public Movie save(Movie mv) throws DataAccessException;
	
	public void delete(Integer id) throws DataAccessException;
	
	public void changeStatus(String user_id, boolean status) throws DataAccessException;
}
