package com.uca.cinema.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer>{
	
//	@Query(value = "select * from showtime where showdate = :showdate and schedule between time :startTime and time :endTime + CAST(:duration AS INTERVAL) and id_theater = :theaterid limit 1",
//			nativeQuery = true)
//	public Showtime isAvailable(@Param("showdate")Date showdate, @Param("startTime")String startTime, 
//			@Param("endTime")String endTime, @Param("duration")String duration, @Param("theaterid")Integer theaterid);
//	
	@Query(value = "select * from showtime where showdate = ?1 and schedule between CAST(?2 AS TIME) and CAST(?3 AS TIME) + CAST(?4 AS INTERVAL) and id_theater = ?5 limit 1",
			nativeQuery = true)
	public Showtime isAvailable(Date showdate, Date startTime, 
			Date endTime, String duration, Integer theaterid);
	
}
