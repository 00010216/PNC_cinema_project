package com.uca.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Movie;
import com.uca.cinema.domain.Showtime;
import com.uca.cinema.service.ShowtimeService;

@Controller
@SessionAttributes(MainController.USER_SESSION)
@RequestMapping("/admin")
public class ShowtimeController {
	
	@Autowired
	ShowtimeService showtimeService;
	
	@ModelAttribute("auth")
	public boolean authUser(HttpSession session) {
		CUser u = (CUser) session.getAttribute(MainController.USER_SESSION);
		return u.getIsadmin() && u.getLoggedin();
	}
	
	@ModelAttribute(MainController.USER_SESSION)
	public CUser sessionUser(HttpSession session) {
		return (CUser) session.getAttribute(MainController.USER_SESSION);
	}
	
	@RequestMapping("/showtimes")
	public ModelAndView showtimeslist() {
		ModelAndView mav = new ModelAndView();
		List<Showtime> showtimes = null;
		try {
			showtimes = showtimeService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(showtimes != null)
			mav.addObject("showtimes", showtimes);
		else
			mav.addObject("noList", "No se encontraron funciones");
		mav.setViewName("admin/showtimes");
		return mav;
	}
	
	@RequestMapping("/addShowtime")
	public ModelAndView showtimeForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/showtimeform");
		return mav;
	}
}
