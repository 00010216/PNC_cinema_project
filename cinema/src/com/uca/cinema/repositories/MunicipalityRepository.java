package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.Municipality;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer>{

}
