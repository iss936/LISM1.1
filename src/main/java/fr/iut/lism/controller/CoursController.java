package fr.iut.lism.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.dao.implementation.CoursDaoImpl;

@Controller
public class CoursController {
	
	@Resource protected CoursDaoImpl coursDao;
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String list(Model model)
	{
		List<Cours> ls = coursDao.findAll();
		model.addAttribute("courseList",ls);		
		return "course/list";
	}
	
	@RequestMapping(value="/FicheCoursSession", method = RequestMethod.GET)
	public String listCoursSession(Model model, @RequestParam(value="idCours") int idCours) {
		model.addAttribute("coursSessionList", coursDao.findAll(idCours));
		model.addAttribute("cours", coursDao.getUnCours(idCours));
		return "listeCours";
	}
}
