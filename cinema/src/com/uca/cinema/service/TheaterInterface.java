package com.uca.cinema.service;

import java.util.List;

import com.uca.cinema.domain.Theater;

public interface TheaterInterface {
	public List<Theater> getAll();
	public Theater findOne(Integer id);	
	public void create(Theater theater);
	public void update(Theater theater);
	public void delete(Integer id);
}
