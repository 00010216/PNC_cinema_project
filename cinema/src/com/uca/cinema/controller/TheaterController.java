package com.uca.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cinema.domain.Theater;

@Controller
public class TheaterController {
	
	@RequestMapping(value="/edit-theater", method=RequestMethod.GET)
	public ModelAndView editTheater() {
		ModelAndView mav = new ModelAndView();
				
		mav.addObject("theater", new Theater());
		mav.setViewName("admin/theater");
		return mav;
	}
	
}
