package com.uca.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Movie;
import com.uca.cinema.service.MovieService;

@Controller
@SessionAttributes(MainController.USER_SESSION)
@RequestMapping("/admin")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@ModelAttribute("auth")
	public boolean authUser(HttpSession session) {
		CUser u = (CUser) session.getAttribute(MainController.USER_SESSION);
		return u.getIsadmin() && u.getLoggedin();
	}
	
	@ModelAttribute(MainController.USER_SESSION)
	public CUser sessionUser(HttpSession session) {
		return (CUser) session.getAttribute(MainController.USER_SESSION);
	}
	
	@RequestMapping("/movies")
	public ModelAndView storeList(ModelMap map, @ModelAttribute("auth") boolean auth) {
		if(!auth) {
			map.clear();
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		List<Movie> movies = null;
		try {
			movies = movieService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(movies.isEmpty())
			mav.addObject("movies", movies);
		else
			mav.addObject("nolist", "No se encontraron películas");
		mav.setViewName("admin/movies");
		return mav;
	}
	
	@RequestMapping("/addMovie")
	public ModelAndView storeForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("movie",  new Movie());
		mav.setViewName("admin/moviesform");
		return mav;
	}
	
	@PostMapping("/movie/save")
	ModelAndView save(@Valid @ModelAttribute Movie movie, BindingResult br,
			RedirectAttributes ra, HttpServletRequest req, @ModelAttribute(MainController.USER_SESSION) CUser user) {
		ModelAndView mav = new ModelAndView();
		if (user.getLoggedin()) {
			mav.clear();
			return new ModelAndView("redirect:/");
		}
		if (br.hasErrors()) {
			mav.setViewName("moviesform");
		} else {
			RedirectView rv = new RedirectView(req.getContextPath() + "/admin/movies");
			rv.setExposeModelAttributes(false);
			try {
				movieService.save(movie);
				ra.addFlashAttribute("success", true);	
				ra.addFlashAttribute("message", "La película se guardó con éxito");
			} catch(Exception e) {
				e.printStackTrace();
				ra.addFlashAttribute("success", false);
				ra.addFlashAttribute("message", "No se ha podido guardar la película, intenténtelo más tarde");
			}
			mav.setView(rv);
		}
		return mav;
	}
	
}
