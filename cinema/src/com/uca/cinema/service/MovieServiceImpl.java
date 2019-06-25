package com.uca.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uca.cinema.domain.Movie;
import com.uca.cinema.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> findAll() throws DataAccessException {
		return movieRepository.findAll();
	}

	@Override
	public Movie findOne(Integer id) throws DataAccessException {
		return movieRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Movie save(Movie mv) throws DataAccessException {
		return movieRepository.save(mv);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws DataAccessException {
		Movie m = findOne(id);
		movieRepository.delete(m);	
	}
}
