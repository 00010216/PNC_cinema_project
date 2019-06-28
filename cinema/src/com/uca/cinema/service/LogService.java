package com.uca.cinema.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uca.cinema.controller.MainController;
import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.LogAction;
import com.uca.cinema.repositories.LogRepository;
import com.uca.cinema.repositories.UserRepository;

@Service
@SessionAttributes(MainController.USER_SESSION)
public class LogService implements LogInterface{

	@Autowired
	LogRepository logRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void create(String user_id, String description, CUser userLoggedIn) {		
		LogAction logAction = new LogAction();
		
		logAction.setCUser(userRepository.findById(Integer.valueOf(user_id)).get());
		
		logAction.setDescription(description);
		logAction.setCAdmin(userLoggedIn);
		Date date = new Date();        
		
		logAction.setCreatedAt(new Timestamp(date.getTime()));
		
		logRepository.save(logAction);
	}

	@Override
	public List<LogAction> findAll() {		
		return logRepository.getAllByName();
	}

}
