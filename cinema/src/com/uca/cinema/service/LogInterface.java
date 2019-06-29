package com.uca.cinema.service;

import java.util.List;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.LogAction;

public interface LogInterface {
	public List<LogAction> findAll();
	public void create(String user_id, String reason, CUser userLoggedIn);
}
