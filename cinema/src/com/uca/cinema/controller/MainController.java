package com.uca.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.service.LoginService;

@Controller
public class MainController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/")
	public String index() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/perform_login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam String username, @RequestParam String password) {
		ModelAndView mav = new ModelAndView();
		try {
			CUser user  = loginService.findbyUserAndPass(username, password);
			if (user != null) {
				if(user.getIsadmin())
					return new ModelAndView("redirect:/admin/home","user",user);
				else return new ModelAndView("redirect:/user/home");
			} else {
				mav.setViewName("login");
				mav.addObject("error", "Credenciales incorrectas");
			}
		}
		catch(Exception e) {
			mav.addObject("error","Algo salió mal - No se pudo conectar");
			e.printStackTrace();
		}
		return mav;
	}
	
	
}
