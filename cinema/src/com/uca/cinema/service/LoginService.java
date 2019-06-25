package com.uca.cinema.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.CUser;

@Service
public interface LoginService {
	public CUser findbyUserAndPass(String user, String password) throws DataAccessException;
}
