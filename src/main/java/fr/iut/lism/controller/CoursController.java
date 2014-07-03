package fr.iut.lism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Cours;
import fr.iut.lism.service.interfaces.CoursService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class CoursController {
	
	@Autowired protected CoursService coursService;
	@Autowired protected EtudiantService etudiantService;
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String list(Model model) {
		List<Cours> ls = coursService.getLesCours();
		model.addAttribute("courseList",ls);
		return "course/list";
	}
	
	@RequestMapping(value="/FicheCoursSession", method = RequestMethod.GET)
	public String listCoursSession(Model model, @RequestParam(value="idCours") int idCours) {
		model.addAttribute("coursSessionList", coursService.getUnCours(idCours).getLesCoursSession());
		model.addAttribute("cours", coursService.getUnCours(idCours));
		return "listeCours";
	}
}
