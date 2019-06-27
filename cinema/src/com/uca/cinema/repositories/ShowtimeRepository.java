package com.uca.cinema.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer>{
	
	@Query(value = "select * from showtime where showdate = ?1 and schedule between ?2 and ?3 + interval ?4 and id_theater = ?5 limit 1",
			nativeQuery = true)
	public Showtime isAvailable(Date showdate, Date startTime, Date endTime, String duration, Integer theaterid);
	
}
