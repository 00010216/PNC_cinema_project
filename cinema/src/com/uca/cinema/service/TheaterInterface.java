package com.uca.cinema.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cinema.domain.Theater;

public interface TheaterInterface {
	public List<Theater> getAll();
	
	public Theater findOne(Integer id);
	
	public void create(Theater theater);
	
	public void update(Theater theater);
	
	public void deleteById(Integer id);
	
	public void changeStatus(String theater_id, boolean status) throws DataAccessException;
}
