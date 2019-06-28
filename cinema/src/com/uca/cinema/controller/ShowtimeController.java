package com.uca.cinema.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.uca.cinema.domain.CUser;
import com.uca.cinema.domain.Movie;
import com.uca.cinema.domain.Showtime;
import com.uca.cinema.domain.ShowtimeFormat;
import com.uca.cinema.domain.Theater;
import com.uca.cinema.dto.ShowtimeDTO;
import com.uca.cinema.repositories.ShowtimeFormatRepository;
import com.uca.cinema.service.MovieService;
import com.uca.cinema.service.ShowtimeService;
import com.uca.cinema.service.TheaterInterface;

@Controller
@SessionAttributes(MainController.USER_SESSION)
@RequestMapping("/admin")
public class ShowtimeController {
	
	Logger log = Logger.getLogger("showtimes");
	
	@Autowired
	ShowtimeService showtimeService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	TheaterInterface theaterService;
	
	@Autowired
	ShowtimeFormatRepository stfRepository;
	
	@ModelAttribute("auth")
	public boolean authUser(HttpSession session, @SessionAttribute(name = MainController.USER_SESSION, required = false) CUser loggeduser) {
		return loggeduser != null ? loggeduser.getIsadmin() && loggeduser.getLoggedin() : false;
	}
	
	@ModelAttribute("movies")
	public List<Movie> movieslist(){
		List<Movie> movies = new ArrayList<>();
		try {
			movies = movieService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	@ModelAttribute("theaters")
	public List<Theater> theaterlist(){
		List<Theater> theaters = new ArrayList<>();
		try {
			theaters = theaterService.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return theaters;
	}
	
	@ModelAttribute("formats")
	public List<ShowtimeFormat> formatlist(){
		List<ShowtimeFormat> formats = new ArrayList<>();
		try {
			formats = stfRepository.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return formats;
	}
	
	@RequestMapping("/showtimes")
	public ModelAndView showtimeslist(ModelMap map, @ModelAttribute("auth") boolean auth) {
		if(!auth) {
			map.clear();
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		List<Showtime> showtimes = null;
		try {
			showtimes = showtimeService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(showtimes != null)
			mav.addObject("showtimes", showtimes);
		else
			mav.addObject("noList", "No se encontraron funciones");
		mav.setViewName("admin/showtimes");
		return mav;
	}
	
	@RequestMapping(path="/saveShowtime", method = RequestMethod.POST)
	public ModelAndView saveStore(@Valid @ModelAttribute("showtimeDTO") ShowtimeDTO showtimeDTO,
			BindingResult result, RedirectAttributes ra,HttpServletRequest req, @ModelAttribute("auth") boolean auth){
		ModelAndView mav = new ModelAndView();
		if (!auth) {
			mav.clear();
			return new ModelAndView("redirect:/");
		}
		if(result.hasErrors()) {
			log.info("tiene errores");
			mav.addObject("showtimeDTO", showtimeDTO);
			mav.setViewName("admin/showtimeform");
		} else {
			try {
				if(showtimeService.isAvailable(showtimeDTO)) {
					log.info("horarios que chocan");
					mav.addObject("showtimeDTO", showtimeDTO);
					mav.addObject("message", "No se puede crear la función para la fecha, hora y sala seleccionados.");
					mav.setViewName("admin/showtimeform");
				} else {
					log.info("guardado");
					showtimeService.save(showtimeDTO);
					RedirectView rv = new RedirectView(req.getContextPath()+"/admin/showtimes");
					rv.setExposeModelAttributes(false);
					ra.addFlashAttribute("message", "Función guardada con éxito");
					mav.setView(rv);
				}
			}
			catch(Exception e) {
				log.info("no se pudo guardar");
				mav.addObject("message", "No se ha podido guardar el empleado, intente más tarde");
				mav.setViewName("admin/showtimeform");
				e.printStackTrace();
			}
		}
		return mav;
	}
	
	@RequestMapping("/addShowtime")
	public ModelAndView showtimeForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("showtimeDTO", new ShowtimeDTO());
		mav.setViewName("admin/showtimeform");
		return mav;
	}
	
	@RequestMapping("/showtime/edit/{id}")
	public String editStore(@PathVariable("id") Integer code, ModelMap m, @ModelAttribute("auth") boolean auth){
		if(!auth) {
			m.clear();
			return "redirect:/";
		}
		try {
			ShowtimeDTO e = showtimeService.findOne(code);
			m.addAttribute("showtimeDTO", e);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/showtimeform";
	}
}
