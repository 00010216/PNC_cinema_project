package com.uca.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.cinema.domain.CUser;

@Controller
public class UserController {
	
	@RequestMapping(value="/admin/user-register")
	public ModelAndView userRegister() {												
		ModelAndView mav = new ModelAndView();
		CUser user = new CUser();
		
		mav.addObject("CUser", user);
		
		mav.setViewName("admin/user");
		
		return mav;
	}
		
}
