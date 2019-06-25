package com.uca.cinema.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.CUser;

@Service
public interface LoginService {
	
	public CUser authUser(String user, String password) throws DataAccessException;
	
	public void sessionUser(Boolean loggedin, Integer iduser) throws DataAccessException;
	
}
