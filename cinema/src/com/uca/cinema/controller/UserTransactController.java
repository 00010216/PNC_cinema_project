package com.uca.cinema.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Movie;
import com.uca.cinema.domain.Showtime;
import com.uca.cinema.service.MovieService;
import com.uca.cinema.service.ShowtimeService;

@Controller
@SessionAttributes(MainController.USER_SESSION)
@RequestMapping("/user")
public class UserTransactController {
	
	/*VISTAS DE USUARIO*/
	@Autowired
	MovieService movieService;
	
	@Autowired
	ShowtimeService showtimeService;
	
	@ModelAttribute("auth")
	public boolean authUser(HttpSession session, @SessionAttribute(name = MainController.USER_SESSION, required = false) CUser loggeduser) {
		return loggeduser != null ? !loggeduser.getIsadmin() && loggeduser.getLoggedin() && loggeduser.getStatus() : false;
	}
	
	@RequestMapping("/movies")
	public ModelAndView show(ModelMap map, @ModelAttribute("auth") boolean auth) {
		if(!auth) {
			map.clear();
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		List<Movie> movies = null;
		try {
			movies = movieService.findAllActive();
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
	
	//Devuelve detalle pelicula y funciones disponibles para seleccionar
	@RequestMapping("/movie/detail/{idMovie}")
	public String showUDetail(@PathVariable Integer idMovie, ModelMap m, @ModelAttribute("auth") boolean auth){
		if(!auth) {
			m.clear();
			return "redirect:/";
		}
		try {
			Movie movie= movieService.findMovieWithShows(idMovie);
			m.addAttribute("movie", movie);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "user/u_moviedetail";
	}
	
	/*Metodo debe cambiarse a post pq recibira datos de la funcion tambien y de usuario*/
	@RequestMapping("/movie/reservation/{idShowtime}")
	public String openForm(@PathVariable Integer idShowtime, ModelMap m,
			@ModelAttribute(MainController.USER_SESSION) CUser user, @ModelAttribute("auth") boolean auth){
		if(!auth) {
			m.clear();
			return "redirect:/";
		}
		try {
			Showtime showtime = showtimeService.findById(idShowtime);
			m.addAttribute("showtime", showtime);
			m.addAttribute("userbalance", user.getBalance());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "user/moviereservation";
	}
	
	@PostMapping("/ticket/save")
	public ModelAndView validateForm(@RequestParam("usebalance") boolean usebalance, 
				@RequestParam("balance") double balance, 
				@RequestParam("seats") int seats, 
				@RequestParam("idshowtime") int idshowtime,
				ModelMap m,
			@ModelAttribute(MainController.USER_SESSION) CUser user, @ModelAttribute("auth") boolean auth){
		ModelAndView mav = new ModelAndView();
		if(!auth) {
			mav.clear();
			return new ModelAndView("redirect:/");
		}
		
		if(usebalance) {
			double remanente = balance - user.getBalance().doubleValue();
			if(remanente < 0) {
				mav.addObject("message","El saldo disponible no es suficiente para completar la trasacción");
				mav.setViewName("user/moviereservation");
			}
			else {
				mav.addObject("idShowtime", idshowtime);
				mav.addObject("remanente", remanente);
				mav.setViewName("user/tickets");
				//mav.addObject("", attributeValue)
			}
		}
		return mav;
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
	
	//vista de resumen del ticket
	@RequestMapping("/user/ticket/save")
	public ModelAndView showTicket() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/ticket");
		return mav;
	}
}
