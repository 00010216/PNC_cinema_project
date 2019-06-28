package com.uca.cinema.controller;

import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Country;
import com.uca.cinema.domain.Movie;
import com.uca.cinema.domain.Municipality;
import com.uca.cinema.domain.Showtime;
import com.uca.cinema.domain.Ticket;
import com.uca.cinema.service.CountryInterface;
import com.uca.cinema.service.MunicipalityInterface;
import com.uca.cinema.service.TicketInterface;
import com.uca.cinema.service.UserInterface;

@Controller
@SessionAttributes(MainController.USER_SESSION)
public class TicketController {
	
	@Autowired
	TicketInterface ticketService;
	
	
	@ModelAttribute("auth")
	public boolean authUser(HttpSession session, @SessionAttribute(name = MainController.USER_SESSION, required = false) CUser loggeduser) {
		return loggeduser != null ? loggeduser.getIsadmin() && loggeduser.getLoggedin() : false;
	}			
	
	@ModelAttribute(MainController.USER_SESSION)
	public CUser sessionUser(HttpSession session) {
		return (CUser) session.getAttribute(MainController.USER_SESSION);
	}
	
	
	@RequestMapping(value="/admin/logs")
	public ModelAndView logs(ModelMap map, @ModelAttribute("auth") boolean auth) {			
		ModelAndView mav = new ModelAndView();								
		
		mav.addObject("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		mav.setViewName("admin/logs");
		
		return mav;
	}
	
	@RequestMapping(value="/admin/getLogsFiltered")
	@Transactional(propagation = Propagation.REQUIRED)
	public ModelAndView getLogsFiltered(@RequestParam Date fromDate, @RequestParam Date toDate ,ModelMap map, @ModelAttribute("auth") boolean auth) {	
		if(!auth) {
			map.clear();
			return new ModelAndView("redirect:/");
		}				
		ModelAndView mav = new ModelAndView();
		
		CUser  usuario = (CUser) map.get(MainController.USER_SESSION);
		
		List<Ticket> tickets = ticketService.getAllTicketsByNameBetweenDates(usuario.getIdUser(), fromDate, toDate);					
		ArrayList<Showtime> showTimes = new ArrayList<>();
		ArrayList<String> ticketInfo = new ArrayList<>();
		
		for(Ticket ticket : tickets) {		
			ticketInfo.add(ticket.getShowtime().getMovie().getTitle() + "%" + ticket.getShowtime().getSchedule() + "%" + ticket.getUsedBalance() + "%" + ticket.getTotal());
		}								
		
		mav.addObject("logs", tickets);
		mav.addObject("info", ticketInfo);				
		
		mav.addObject("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		mav.addObject("showTimes", showTimes);
					
		mav.setViewName("admin/logs");
		
		return mav;
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	    		 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	
}
