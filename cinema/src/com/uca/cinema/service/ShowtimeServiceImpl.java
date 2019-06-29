package com.uca.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

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
	
	Logger log = Logger.getLogger("Showtimeservice");

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
	public ShowtimeDTO findOne(Integer id) throws DataAccessException {
		Showtime showtime = str.findById(id).get();
		ShowtimeDTO showtimeDTO = new ShowtimeDTO();
		showtimeDTO.setAvaliableSeats(showtime.getAvaliableSeats());
		showtimeDTO.setCreatedBy(showtime.getCreatedBy());
		showtimeDTO.setCreatedDate(showtime.getCreatedDate());
		showtimeDTO.setIdmovie(showtime.getMovie().getIdMovie());
		showtimeDTO.setIdShowtime(showtime.getIdShowtime());
		showtimeDTO.setIdShowtimeFormat(showtime.getShowtimeFormat().getIdStFormat());
		showtimeDTO.setIdTheater(showtime.getTheater().getIdTheater());
		showtimeDTO.setPrice(showtime.getPrice());
		showtimeDTO.setSchedule(new SimpleDateFormat("HH:mm").format(showtime.getSchedule()));
		showtimeDTO.setShowdate(new SimpleDateFormat("yyyy-MM-dd").format(showtime.getShowdate()));
		showtimeDTO.setStatus(showtime.getStatus());
		
		return showtimeDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Showtime save(ShowtimeDTO sh) throws DataAccessException, ParseException {
		
		Theater theater = thr.findById(sh.getIdTheater()).get();
		Movie movie = mr.findById(sh.getIdmovie()).get();
		ShowtimeFormat stformat = stfr.findById(sh.getIdShowtimeFormat()).get();
		
		Showtime showtime = new Showtime();
		showtime.setIdShowtime(sh.getIdShowtime());
		showtime.setMovie(movie);
		showtime.setTheater(theater);
		showtime.setShowtimeFormat(stformat);
		showtime.setAvaliableSeats(theater.getCapacity());
		showtime.setPrice(sh.getPrice());
		showtime.setSchedule(parseDate(sh.getSchedule(), "HH:mm"));
		showtime.setShowdate(parseDate(sh.getShowdate(), "yyyy-MM-dd"));
		showtime.setStatus(sh.getStatus());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = new Date();
			String modifiedDate = df.format(date);
			if(sh.getCreatedDate() == null) {
				showtime.setCreatedDate(df.parse(modifiedDate));
				showtime.setCreatedBy(1);
			}
			showtime.setUpdatedDate(df.parse(modifiedDate));
			showtime.setUpdatedBy(1);
			
			str.save(showtime);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return showtime;
		
	}

	@Override
	public boolean isAvailable(ShowtimeDTO sh) throws DataAccessException {
		Movie m = mr.findById(sh.getIdmovie()).get();
		int duration = m.getRuntime()+20;
		Date showdate=null, schedule = null;
		
		log.info("hora recibida:"+sh.getSchedule());
		
		try {
			showdate = new SimpleDateFormat("yyyy-MM-dd").parse(sh.getShowdate());
			schedule = new SimpleDateFormat("HH:mm").parse(sh.getSchedule());
			log.info("hora parseada:"+schedule);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		log.info("idtheater:"+sh.getIdTheater());
		
		Showtime testshowtime = str.isAvailable(showdate, schedule,
				schedule, String.valueOf(duration)+" minutes", sh.getIdTheater());
		if(testshowtime!=null)
			log.info("no disponible - Funcion obtenida"+testshowtime.getIdShowtime());
		else log.info("el horario esta disponible");
		return testshowtime != null;
	}

	private Date parseDate(String date, String format) throws ParseException
	{
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}

	@Override
	public Showtime findById(Integer id) throws DataAccessException {
		return str.findById(id).get();
	}

	@Override
	public void changeStatus(String theater_id, boolean status){
		Showtime s = str.findById(Integer.valueOf(theater_id)).get();
		s.setStatus(status);
		str.save(s);
	}

	
	
	
}
