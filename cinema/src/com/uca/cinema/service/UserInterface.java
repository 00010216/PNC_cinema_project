package com.uca.cinema.service;

import java.util.List;

import com.uca.cinema.domain.CUser;

public interface UserInterface {
	public List<CUser> findAll();
	public CUser findOne(Integer id);
	public void create(CUser user);
	public void update(CUser user);
}
