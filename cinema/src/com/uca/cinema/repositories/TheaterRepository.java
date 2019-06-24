package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.cinema.domain.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer>{
	
}
