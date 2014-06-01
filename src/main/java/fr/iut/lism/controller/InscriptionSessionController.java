package fr.iut.lism.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Etudiant;
import fr.iut.lism.service.interfaces.CoursSessionService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class InscriptionSessionController {
	
	@Autowired protected EtudiantService etudiantServ;
	@Autowired protected CoursSessionService coursSessionServ;
	
	@RequestMapping(value = "/InscriptionCours", method = RequestMethod.POST)
	public String inscription(Model model, @RequestParam("idCoursSession") int idCoursSession, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Etudiant e = (Etudiant) session.getAttribute("etudiant"); //Récupération de l'étudiant dans la session
		etudiantServ.createInscription(e, coursSessionServ.getUnCoursSession(idCoursSession));
		return "course/list";
	}
}
