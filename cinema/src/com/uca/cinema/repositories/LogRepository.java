package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.LogAction;

@Repository
public interface LogRepository extends JpaRepository<LogAction, Integer>{

}
