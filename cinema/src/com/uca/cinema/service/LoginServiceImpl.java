package com.uca.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.repositories.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public CUser findbyUserAndPass(String user, String password) throws DataAccessException {
		return userRepository.findFirstByUsernameAndPasswd(user, password);
	}
	
}
