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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Movie;
import com.uca.cinema.domain.Ticket;
import com.uca.cinema.service.MovieService;

@Controller
@SessionAttributes(MainController.USER_SESSION)
@RequestMapping("/admin")
public class MovieController {
	
	Logger logger = Logger.getLogger("Movies");
	
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
	public ModelAndView storeForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("movie",  new Movie());
		mav.setViewName("admin/moviesform");
		return mav;
	}
	
	@PostMapping("/movie/save")
	ModelAndView save(@Valid @ModelAttribute("movie") Movie movie, BindingResult br,
			RedirectAttributes ra, HttpServletRequest req, @ModelAttribute("auth") boolean auth) {
		ModelAndView mav = new ModelAndView();
		logger.log(Level.SEVERE, "Iniciando el metodo save");
		if (!auth) {
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
			ra.addFlashAttribute("message", "La pel�cula fue removida con �xito");			
		} catch (Exception e) {
			ra.addFlashAttribute("message", "No se pudo remover la pel�cula");
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
	
	/*Para probar vistas de usuario, habra que cambiar links si es necesario*/
	
	/*VISTAS DE USUARIO*/
	
	@RequestMapping("/user/movies")
	public ModelAndView show() {
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
		mav.setViewName("user/u_movies");
		return mav;
	}
	

	@RequestMapping("/user/movie/detail/{idMovie}")
	public String showUDetail(@PathVariable Integer idMovie, Model m){
		try {
			Movie movie= movieService.findOne(idMovie);
			m.addAttribute("movie", movie);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "user/u_moviedetail";
	}
	
	/*Metodo debe cambiarse a post pq recibira datos de la funcion tambien y de usuario*/
	@RequestMapping("/user/movie/reservation/{idMovie}")
	public String openForm(@PathVariable Integer idMovie, Model m){
		try {
			Movie movie= movieService.findOne(idMovie);
			String movieTitle = movie.getTitle();
			m.addAttribute("movietitle", movieTitle);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "user/moviereservation";
	}
	
	/*Guardar info de ticket y guardar y manda info a vista de ticket*/
	
	/**@PostMapping("/user/ticket/save")
	ModelAndView save(@Valid @ModelAttribute Ticket ticket, BindingResult br,
			RedirectAttributes ra,HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		logger.log(Level.SEVERE, "Iniciando el metodo save");
		
		if (br.hasErrors()) {
			/*ver validaciones de form con operaciones de numero asientos y saldo
			mav.setViewName("moviereservation");
			logger.log(Level.SEVERE, "el form tiene errores");
		} else {
			logger.log(Level.SEVERE, "Envio correcto, redirigir a user/ticket");
			RedirectView rv = new RedirectView(req.getContextPath() + "/user/ticket");
			rv.setExposeModelAttributes(false);
			try {
				//ticketService.save(ticket); guardar info de ticket
				logger.log(Level.SEVERE, "Se ingreso a la base de datos");
				ra.addFlashAttribute("success", true);	
				ra.addFlashAttribute("message", "Su reservacion se hizo exitosamente");
			} catch(Exception e) {
				e.printStackTrace();
				ra.addFlashAttribute("success", false);
				ra.addFlashAttribute("message", "No se ha podido generar reservacion, intententelo mas tarde");
			}
			mav.addObject("ticket", ticket);
			mav.setView(rv);
		}
		return mav;
	}**/
	
	@RequestMapping("/user/ticket/save")
	public ModelAndView showTicket() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/ticket");
		return mav;
	}
	
}
