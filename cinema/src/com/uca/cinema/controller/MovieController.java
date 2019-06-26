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
	
	Logger logger = Logger.getLogger("Movies");
	
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
		if(!movies.isEmpty())
			mav.addObject("movies", movies);
		else
			mav.addObject("nolist", "No se encontraron pelÃ­culas");
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
	ModelAndView save(@Valid @ModelAttribute("movie") Movie movie, BindingResult br,
			RedirectAttributes ra, HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		logger.log(Level.SEVERE, "Iniciando el metodo save");
		if (!authUser(session)) {
			mav.clear();
			return new ModelAndView("redirect:/");
		}
		if (br.hasErrors()) {
			mav.setViewName("moviesform");
			logger.log(Level.SEVERE, "el form tiene errores");
		} else {
			logger.log(Level.SEVERE, "Envio correcto, redirigir a admin/movies");
			RedirectView rv = new RedirectView(req.getContextPath() + "/admin/movies");
			rv.setExposeModelAttributes(false);
			try {
				movieService.save(movie);
				logger.log(Level.SEVERE, "Se ingreso a la base de datos");
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
	public String editMovie(@PathVariable Integer idmovie, Model m){
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
	public RedirectView deleteStore(@PathVariable Integer idMovie, HttpServletRequest req, RedirectAttributes ra) {
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
	public String showDetail(@PathVariable Integer idmovie, Model m){
		try {
			Movie movie= movieService.findOne(idmovie);
			m.addAttribute("movie", movie);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/moviedetail";
	}
}
