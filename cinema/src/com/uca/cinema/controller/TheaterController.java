package com.uca.cinema.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.cinema.domain.Theater;
import com.uca.cinema.service.TheaterInterface;

@Controller
public class TheaterController {
	
	@Autowired
	TheaterInterface theaterService;
	
	@RequestMapping(value="/create-theater", method=RequestMethod.GET)
	public ModelAndView createTheater(Model model) {
		ModelAndView mav = new ModelAndView();
		
		if(!model.containsAttribute("theater")) {
			mav.addObject("theater", new Theater());
		}
				
		mav.setViewName("admin/theater");
		return mav;
	}
	
	@RequestMapping(value="/create-theater-register", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute Theater theater, BindingResult result, RedirectAttributes redirectAttributes) {
		
		String redirect = "redirect:/";		
		if (result.hasErrors()) {					
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.theater", result);
            redirectAttributes.addFlashAttribute("theater", theater);                        			
			
            redirect += "create-theater";
		}
		else {						
			theaterService.create(theater);
			redirectAttributes.addAttribute("message", "Se creo la Sala con exito");
			redirect += "theaters";
		}
		
		
		return redirect;
	}
	
	@RequestMapping(value="/theaters")
	public ModelAndView showTheaters(@RequestParam(required=false) String message) {
		ModelAndView mav = new ModelAndView();
		
		List<Theater> theaters = theaterService.getAll();
		
		mav.addObject("theaters", theaters);
		mav.addObject("message", message);
		mav.setViewName("admin/theaters");
		return mav;
	}
	
	
}
