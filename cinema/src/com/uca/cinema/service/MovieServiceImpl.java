package com.uca.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public List<Movie> findAllActive() throws DataAccessException {
		return movieRepository.findByStatus(true);
	}

	@Override
	public Movie findOne(Integer id) throws DataAccessException {
		return movieRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Movie save(Movie mv) throws DataAccessException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = new Date();
			String modifiedDate = df.format(date);
			if(mv.getCreatedDate() == null) mv.setCreatedDate(df.parse(modifiedDate));
			mv.setUpdatedDate(df.parse(modifiedDate));
			mv.setCreatedBy(1);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return movieRepository.save(mv);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws DataAccessException {
		Movie m = findOne(id);
		movieRepository.delete(m);	
	}

	@Override
	public Movie findMovieWithShows(Integer id) throws DataAccessException {
		return movieRepository.fetchMovieWithShowtimesById(id);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void changeStatus(String movie_id, boolean status) throws DataAccessException {		
		Movie m = findOne(Integer.valueOf(movie_id));
		m.setStatus(status);
		movieRepository.save(m);
	}
}
