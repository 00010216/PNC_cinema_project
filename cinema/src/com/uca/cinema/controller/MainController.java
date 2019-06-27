package com.uca.cinema.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.service.LoginService;

@Controller
@SessionAttributes(MainController.USER_SESSION)
public class MainController {

	public final static String USER_SESSION = "userlog";
	Logger log = Logger.getLogger(MainController.class.getSimpleName());
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/")
	public String index(HttpSession session) {
		CUser user = (CUser)session.getAttribute(USER_SESSION);
		if (user != null && user.getLoggedin()) {
			if(user.getIsadmin())
				return "redirect:/admin/movies";
			else return "redirect:/user/home";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpSession session, ModelMap model, @SessionAttribute(name = USER_SESSION, required = false) CUser user) {
		if (user != null && user.getLoggedin()) {
			if(user.getIsadmin())
				return "redirect:/admin/movies";
			else return "redirect:/user/home";
		}
		//model.clear();
		return "login";
	}
	
	@RequestMapping(value="/perform_login", method=RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes ra, 
			HttpSession session, @SessionAttribute(name = USER_SESSION, required = false) CUser loggeduser) {
		if(loggeduser != null) {
			ra.addFlashAttribute("error","Ya existe una cuenta iniciada en este navegador");
			return "redirect:/";
		}
		
		if(username.trim().isEmpty() || password.trim().isEmpty()) {
			ra.addFlashAttribute("error", "Complete los campos");
		}
		
		try {
			CUser user  = loginService.authUser(username, password);
			if (user != null) {
				if(user.getLoggedin()) {
					ra.addFlashAttribute("error", "El usuario especificado ya está conectado. Por favor cierre otras cuentas para continuar.");
				}else {
					loginService.sessionUser(true, user.getIdUser());
					user.setLoggedin(true);
					session.setAttribute(USER_SESSION, user);
					if(user.getIsadmin())
						return "redirect:/admin/movies";
					else return "redirect:/user/home";
				}
			} else {
				ra.addFlashAttribute("error", "Credenciales incorrectas");
			}
		}
		catch(Exception e) {
			ra.addFlashAttribute("error","Algo salió mal - No se pudo conectar, inténtelo más tarde");
			e.printStackTrace();
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	String logout(HttpSession session, SessionStatus status, @SessionAttribute(name = USER_SESSION, required = false) CUser loggeduser) {
		try {
			loginService.sessionUser(false, loggeduser.getIdUser());
			session.removeAttribute(USER_SESSION);
			status.setComplete();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
		

	}
}
