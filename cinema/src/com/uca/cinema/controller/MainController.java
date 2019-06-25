package com.uca.cinema.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<String> images = Arrays.asList("resources/img/toystory.jpg", "resources/img/reyleon.jpg", "resources/img/it.jpg","resources/img/mib.jpg","resources/img/toystory.jpg","resources/img/toystory.jpg","resources/img/toystory.jpg");
		mav.setViewName("admin/moviesform");
		mav.addObject("image",images);
		return mav;
	}
}
