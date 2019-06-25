package com.uca.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.repositories.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public CUser authUser(String user, String password) throws DataAccessException {
		CUser u = new CUser();
		u = userRepository.findFirstByUsernameAndPasswd(user, password);
		return u;
	}
	
	@Transactional
	public void sessionUser(Boolean loggedin, Integer iduser) throws DataAccessException  {
		userRepository.setUserInfoById(loggedin, iduser);
	}

	
}
