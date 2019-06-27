package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.ShowtimeFormat;

@Repository
public interface ShowtimeFormatRepository extends JpaRepository<ShowtimeFormat, Integer> {

}
