package com.uca.cinema.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.service.LoginService;

@Controller
@SessionAttributes(MainController.USER_SESSION)
public class MainController {
	
	public final static String USER_SESSION = "userlog";
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/")
	public String index(HttpSession session) {
		CUser user = (CUser)session.getAttribute(USER_SESSION);
		if (session.getAttribute(USER_SESSION) != null && user.getLoggedin()) {
			return "redirect:/movies";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/perform_login", method=RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes ra, HttpSession session) {
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
					session.setAttribute(USER_SESSION, user);
					if(user.getIsadmin())
						return "redirect:/admin/home";
					else return "redirect:/user/home";
				}
			} else {
				ra.addFlashAttribute("Credenciales incorrectas");
			}
		}
		catch(Exception e) {
			ra.addFlashAttribute("error","Algo salió mal - No se pudo conectar, inténtelo más tarde");
			e.printStackTrace();
		}
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	String logout(HttpSession session) {
		try {
			CUser u = (CUser) session.getAttribute(MainController.USER_SESSION);
			loginService.sessionUser(false, u.getIdUser());
			session.setAttribute(USER_SESSION, null);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
		
	}
}
