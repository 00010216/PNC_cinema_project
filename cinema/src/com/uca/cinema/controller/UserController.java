package com.uca.cinema.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Country;
import com.uca.cinema.domain.Municipality;
import com.uca.cinema.domain.Theater;
import com.uca.cinema.service.CountryInterface;
import com.uca.cinema.service.MunicipalityInterface;
import com.uca.cinema.service.UserInterface;

@Controller
public class UserController {
	
	@Autowired
	CountryInterface countryService;
	
	@Autowired
	MunicipalityInterface municipalityService;
	
	@Autowired
	UserInterface userService;
	
	@RequestMapping(value="/admin/userForm")
	public ModelAndView userRegister(Model model) {												
		ModelAndView mav = new ModelAndView();
		
		if(!model.containsAttribute("CUser")) {
			mav.addObject("CUser", new CUser());			
		}
				
		List<Country> countries= countryService.findAll();
		List<Municipality> municipalities = municipalityService.findAll();
		System.out.println(countries.size());
		
		
		mav.addObject("countries", countries);
		mav.addObject("municipalities", municipalities);
		mav.addObject("actionForm", "addUser");
		
		mav.setViewName("user");
		
		return mav;
	}
	
	@RequestMapping(value="/admin/addUser", method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute CUser user, BindingResult result, RedirectAttributes redirectAttributes) {
		
		String redirect = "redirect:/";	
		
		if (result.hasErrors()) {					
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.CUser", result);
            redirectAttributes.addFlashAttribute("CUser", user);                        			
            System.out.println(result.toString() );
            redirect += "admin/userForm";
		}
		else {						
			
			userService.create(user);			
			redirect += "admin/users";
		}
		
		
		return redirect;
	}
	
	@RequestMapping(value="/admin/users")
	public ModelAndView showTheaters(@RequestParam(required=false) String message) {
		ModelAndView mav = new ModelAndView();
		
		List<CUser> users = userService.findAll();
		
		mav.addObject("users", users);
		mav.addObject("message", message);
		mav.setViewName("admin/users");
		return mav;
	}
	
	@RequestMapping(value="/admin/editUserForm")
	@Transactional(propagation = Propagation.REQUIRED)
	public ModelAndView editUser(@RequestParam String user_id) {
		ModelAndView mav = new ModelAndView();
		
		CUser user = userService.findOne(Integer.valueOf(user_id));
						
		mav.addObject("CUser", user);
		mav.addObject("countryName", user.getCountry().getName());
		mav.addObject("municipalityName", user.getMunicipality().getName());
		mav.addObject("actionForm", "editUser" );
				
		mav.setViewName("admin/editUserForm");
		
		return mav;
	}
	
	@RequestMapping(value="/admin/editUser", method=RequestMethod.POST)
	public String editUser(@ModelAttribute CUser user, RedirectAttributes redirectAttributes) {
		String redirect = "redirect:/";			
		
		try {									
			System.out.println("Entro aqu");
			userService.update(user);
            redirectAttributes.addAttribute("message", "Se actualizo el registro correctamente");
            redirect += "admin/users";
		}
		catch(Exception e) {						
			redirectAttributes.addAttribute("user_id", user.getIdUser());
					
			redirect += "admin/editUserForm";
		}
											
		return redirect;
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){	
	     binder.registerCustomEditor(Date.class,     
	    		 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}

}
