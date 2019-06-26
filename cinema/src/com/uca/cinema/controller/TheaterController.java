package com.uca.cinema.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		
		mav.addObject("actionForm", "create-theater-register");
		mav.addObject("header", "Registrar Sala");
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
	
	@RequestMapping(value="/edit-theater")
	public ModelAndView editTheater(@RequestParam String id, Model model) {
		ModelAndView mav = new ModelAndView();
		
		if(!model.containsAttribute("theater")) {
			Theater theater = theaterService.findOne(Integer.valueOf(id));			
			mav.addObject("theater", theater);
		}							
		
		mav.addObject("actionForm", "edit-theater-register");
		mav.addObject("header", "Actualizar Sala");
				
		mav.setViewName("admin/theater");
		return mav;
	}
	
	@RequestMapping(value="/edit-theater-register", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute Theater theater, BindingResult result, RedirectAttributes redirectAttributes) {		
		String redirect = "redirect:/";		
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.theater", result);			
            redirectAttributes.addFlashAttribute("theater", theater);       
            redirectAttributes.addAttribute("id", theater.getIdTheater());
            redirect += "edit-theater";
		}
		else {						
			theaterService.update(theater);
			redirectAttributes.addAttribute("message", "Se actualiz� la Sala con exito");
			redirect += "theaters";
		}							
			
		return redirect;
	}
	
	@RequestMapping(value="/delete-theater")
	public ModelAndView deleteTheater(@RequestParam String id, Model model) {
		ModelAndView mav = new ModelAndView();
		
		if(!model.containsAttribute("theater")) {
			Theater theater = theaterService.findOne(Integer.valueOf(id));			
			mav.addObject("theater", theater);
		}							
		
		mav.addObject("actionForm", "edit-theater-register");
		mav.addObject("header", "Actualizar Sala");
				
		mav.setViewName("admin/theater");
		return mav;
	}
	
	@RequestMapping(value="/delete-theater-element")
	public String deleteTheater(@RequestParam String id, RedirectAttributes redirectAttributes) {												
		try {
			theaterService.delete(Integer.valueOf(id));
			redirectAttributes.addAttribute("message", "Se elimino el registro correctamente");
		}
		catch(Exception e) {
			redirectAttributes.addAttribute("message", "Sucedi� un error al eliminar");
			e.printStackTrace();
		}	             

		return "redirect:/theaters";
	}
	
	
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	    		 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	
	
	
}
