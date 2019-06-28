package com.uca.cinema.service;

import com.uca.cinema.domain.CUser;

public interface LogInterface {
	public void create(String user_id, String reason, CUser userLoggedIn);
}
