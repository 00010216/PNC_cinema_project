package com.uca.cinema.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.LogAction;
import com.uca.cinema.service.LogInterface;

@Controller
@SessionAttributes(MainController.USER_SESSION)
public class LogController {
	
	
	@Autowired
	LogInterface logService;
	
	@ModelAttribute("auth")
	public boolean authUser(HttpSession session, @SessionAttribute(name = MainController.USER_SESSION, required = false) CUser loggeduser) {
		return loggeduser != null ? loggeduser.getIsadmin() && loggeduser.getLoggedin() : false;
	}			
	
	@ModelAttribute(MainController.USER_SESSION)
	public CUser sessionUser(HttpSession session) {
		return (CUser) session.getAttribute(MainController.USER_SESSION);
	}
	
	
	@RequestMapping(value="/admin/logsAdmin")
	@Transactional(propagation = Propagation.REQUIRED)
	public ModelAndView logs(ModelMap map, @ModelAttribute("auth") boolean auth) {			
		ModelAndView mav = new ModelAndView();								
		
		List<LogAction> logActions = logService.findAll();
		ArrayList<CUser> users = new ArrayList<>();
		
		for(LogAction logActionAux : logActions){
			users.add(logActionAux.getCUser());
			logActionAux.getCUser().getUsername();
		}
					
		mav.addObject("logs", logActions);
		mav.addObject("users", users);
		
		mav.addObject("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		mav.setViewName("admin/logsAdmin");
		
		return mav;
	}
	
	

}
