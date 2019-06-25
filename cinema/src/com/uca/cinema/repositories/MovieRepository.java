package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
