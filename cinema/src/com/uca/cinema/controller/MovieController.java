package com.uca.cinema.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.RequestParam;
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
	public boolean authUser(HttpSession session, @SessionAttribute(name = MainController.USER_SESSION, required = false) CUser loggeduser) {
		return loggeduser != null ? loggeduser.getIsadmin() && loggeduser.getLoggedin() : false;
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
		if(!movies.isEmpty())
			mav.addObject("movies", movies);
		else
			mav.addObject("nolist", "No se encontraron películas");
		mav.setViewName("admin/movies");
		return mav;
	}
	
	@RequestMapping("/addMovie")
	public ModelAndView storeForm(ModelMap map, @ModelAttribute("auth") boolean auth) {
		if(!auth) {
			map.clear();
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("movie",  new Movie());
		mav.setViewName("admin/moviesform");
		return mav;
	}
	
	@PostMapping("/movie/save")
	ModelAndView save(@Valid @ModelAttribute("movie") Movie movie, BindingResult br,
			RedirectAttributes ra, HttpServletRequest req, @ModelAttribute("auth") boolean auth) {
		ModelAndView mav = new ModelAndView();
		if (!auth) {
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
				ra.addFlashAttribute("message", "La pelicula se guardo con exitosamente");
			} catch(Exception e) {
				e.printStackTrace();
				ra.addFlashAttribute("success", false);
				ra.addFlashAttribute("message", "No se ha podido guardar la pelicula, intententelo mas tarde");
			}
			mav.setView(rv);
		}
		return mav;
	}
	
	@RequestMapping("/movie/edit/{idmovie}")
	public String editMovie(@PathVariable Integer idmovie, ModelMap m, @ModelAttribute("auth") boolean auth){
		if(!auth) {
			m.clear();
			return "redirect:/";
		}
		try {
			Movie movie= movieService.findOne(idmovie);
			m.addAttribute("action", "Editar");
			m.addAttribute("movie", movie);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/moviesform";
	}
	
	@GetMapping("/movie/delete/{idMovie}")
	public RedirectView deleteStore(@PathVariable Integer idMovie, HttpServletRequest req,
			RedirectAttributes ra, @ModelAttribute("auth") boolean auth) {
		if(!auth) {
			RedirectView rv = new RedirectView(req.getContextPath()+"/");
			rv.setExposeModelAttributes(false);
			return rv;
		}
		RedirectView rv = new RedirectView(req.getContextPath()+"/admin/movies");
		rv.setExposeModelAttributes(false);
		try {
			movieService.delete(idMovie);
			ra.addFlashAttribute("message", "La película fue removida con éxito");			
		} catch (Exception e) {
			ra.addFlashAttribute("message", "No se pudo remover la película");
			e.printStackTrace();
		}
		return rv;
	}
	
	@RequestMapping("/movie/detail/{idmovie}")
	public String showDetail(@PathVariable Integer idmovie, ModelMap m, @ModelAttribute("auth") boolean auth){
		if(!auth) {
			m.clear();
			return "redirect:/";
		}
		try {
			Movie movie= movieService.findOne(idmovie);
			m.addAttribute("movie", movie);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/moviedetail";
	}
	
	@RequestMapping("/movie/updateMovieStatus")
	public String updateMovieStatus(@RequestParam boolean status, @RequestParam String movie_id, ModelMap map,RedirectAttributes redirectAttributes){
		
		try {
			movieService.changeStatus(movie_id, status);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/movies";
	}
	
	
}
