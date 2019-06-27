package com.uca.cinema.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Movie;

@Controller
@SessionAttributes(MainController.USER_SESSION)
@RequestMapping("/admin")
public class ShowtimeController {
	
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
	public ModelAndView storeList() {
		ModelAndView mav = new ModelAndView();
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
