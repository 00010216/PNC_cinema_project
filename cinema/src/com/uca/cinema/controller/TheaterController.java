package com.uca.cinema.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Theater;
import com.uca.cinema.service.TheaterInterface;

@Controller
@SessionAttributes(MainController.USER_SESSION)
public class TheaterController {
	
	@Autowired
	TheaterInterface theaterService;
	
	/*
	@ModelAttribute("auth")
	public boolean authUser(HttpSession session, @SessionAttribute(name = MainController.USER_SESSION, required = false) CUser loggeduser) {
		return loggeduser != null ? loggeduser.getIsadmin() && loggeduser.getLoggedin() : false;
	}*/
	
	@RequestMapping(value="/admin/create-theater", method=RequestMethod.GET)
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
	
	@RequestMapping(value="/admin/create-theater-register", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute Theater theater, BindingResult result, RedirectAttributes redirectAttributes) {
		
		String redirect = "redirect:/";		
		if (result.hasErrors()) {					
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.theater", result);
            redirectAttributes.addFlashAttribute("theater", theater);                        			
			
            redirect += "admin/create-theater";
		}
		else {						
			theaterService.create(theater);
			redirectAttributes.addAttribute("message", "Se creo la Sala con exito");
			redirect += "admin/theaters";
		}
		
		
		return redirect;
	}
	
	@RequestMapping(value="/admin/theaters")
	public ModelAndView showTheaters(@RequestParam(required=false) String message) {
		ModelAndView mav = new ModelAndView();
		
		List<Theater> theaters = theaterService.getAll();
		
		mav.addObject("theaters", theaters);
		mav.addObject("message", message);
		mav.setViewName("admin/theaters");
		return mav;
	}
	
	@RequestMapping(value="/admin/edit-theater")
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
	
	@RequestMapping(value="/admin/edit-theater-register", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute Theater theater, BindingResult result, RedirectAttributes redirectAttributes) {		
		String redirect = "redirect:/";		
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.theater", result);			
            redirectAttributes.addFlashAttribute("theater", theater);       
            redirectAttributes.addAttribute("id", theater.getIdTheater());
            redirect += "admin/edit-theater";
		}
		else {						
			theaterService.update(theater);
			redirectAttributes.addAttribute("message", "Se actualiz� la Sala con exito");
			redirect += "admin/theaters";
		}							
			
		return redirect;
	}
	
	@RequestMapping(value="/admin/delete-theater")
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
	
	@RequestMapping(value="/admin/delete-theater-element")
	public String deleteTheater(@RequestParam String id, RedirectAttributes redirectAttributes) {												
		try {
			theaterService.deleteById(Integer.valueOf(id));
			redirectAttributes.addAttribute("message", "Se elimino el registro correctamente");
		}
		catch(Exception e) {
			redirectAttributes.addAttribute("message", "Sucedi� un error al eliminar");
			e.printStackTrace();
		}	             

		return "redirect:/admin/theaters";
	}
	
	@RequestMapping("/admin/updateTheaterStatus")
	public String updateTheaterStatus(@RequestParam boolean status, @RequestParam String theater_id, ModelMap map,RedirectAttributes redirectAttributes){
		
		try {
			theaterService.changeStatus(theater_id, status);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/theaters";
	}
	
	
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	    		 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
		
	
}
