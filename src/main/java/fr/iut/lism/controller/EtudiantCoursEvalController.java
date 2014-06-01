package fr.iut.lism.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.iut.lism.Etudiant;
import fr.iut.lism.service.interfaces.EtudiantCoursEvalService;

@Controller
public class EtudiantCoursEvalController {
	
	@Autowired protected EtudiantCoursEvalService etudiantCoursEvalServ;
	
	@RequestMapping(value = "/mesResultats", method = RequestMethod.GET)
	public String inscription(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Etudiant e = (Etudiant) session.getAttribute("etudiant"); //Récupération de l'étudiant dans la session
		model.addAttribute("etudiantCoursEvalList", e.getLesEtudiantCoursEval());
		return "listeEtudiantCoursEval";
	}
}
