package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
