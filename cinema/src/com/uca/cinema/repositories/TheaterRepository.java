package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer>{
	
}
