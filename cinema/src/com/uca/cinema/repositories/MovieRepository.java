package com.uca.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.cinema.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	@Transactional(readOnly = true)
	@Query(value = "SELECT m FROM Movie m JOIN FETCH m.showtimes s WHERE m.idMovie = ?1 AND s.status = true")
	Movie fetchMovieWithShowtimesById(Integer id);
	
	List<Movie> findByStatus(boolean status);
}
