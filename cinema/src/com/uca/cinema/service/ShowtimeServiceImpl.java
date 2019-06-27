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
import com.uca.cinema.domain.Showtime;
import com.uca.cinema.domain.ShowtimeFormat;
import com.uca.cinema.domain.Theater;
import com.uca.cinema.dto.ShowtimeDTO;
import com.uca.cinema.repositories.MovieRepository;
import com.uca.cinema.repositories.ShowtimeFormatRepository;
import com.uca.cinema.repositories.ShowtimeRepository;
import com.uca.cinema.repositories.TheaterRepository;

@Service
public class ShowtimeServiceImpl implements ShowtimeService{

	@Autowired
	ShowtimeRepository str;
	
	@Autowired
	MovieRepository mr;
	
	@Autowired
	TheaterRepository thr;
	
	@Autowired
	ShowtimeFormatRepository stfr;
	
	@Override
	public List<Showtime> findAll() throws DataAccessException {
		return str.findAll();
	}

	@Override
	public Showtime findOne(Integer id) throws DataAccessException {
		return str.findById(id).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Showtime save(ShowtimeDTO sh) throws DataAccessException {
		
		Theater theater = thr.findById(sh.getIdTheater()).get();
		Movie movie = mr.findById(sh.getIdmovie()).get();
		ShowtimeFormat stformat = stfr.findById(sh.getIdShowtimeFormat()).get();
		
		Showtime showtime = new Showtime();
		showtime.setIdShowtime(sh.getIdShowtime() != null ? sh.getIdShowtime() : null);
		showtime.setMovie(movie);
		showtime.setTheater(theater);
		showtime.setShowtimeFormat(stformat);
		showtime.setAvaliableSeats(theater.getCapacity());
		showtime.setPrice(sh.getPrice());
		showtime.setSchedule(sh.getSchedule());
		showtime.setShowdate(sh.getShowdate());
		showtime.setStatus(sh.getStatus());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = new Date();
			String modifiedDate = df.format(date);
			if(sh.getCreatedDate() == null) {
				sh.setCreatedDate(df.parse(modifiedDate));
				sh.setCreatedBy(1);
			}
			sh.setUpdatedDate(df.parse(modifiedDate));
			sh.setUpdatedBy(1);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return showtime;
		
	}

	@Override
	public boolean isAvailable(ShowtimeDTO sh) throws DataAccessException {
		Movie m = mr.getOne(sh.getIdmovie());
		String duration = String.valueOf(m.getRuntime()+20).concat("m");
		Showtime available = str.isAvailable(sh.getShowdate(), sh.getSchedule(),
				sh.getSchedule(), duration, sh.getIdTheater());
		return available != null;
	}

}
