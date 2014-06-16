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
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.CoursSessionService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class InscriptionSessionController {
	
	@Autowired protected EtudiantService etudiantServ;
	@Autowired protected CoursSessionService coursSessionServ;
	
	@RequestMapping(value = "/InscriptionCours", method = RequestMethod.POST)
	public String inscription(Model model, @RequestParam("idCoursSession") int idCoursSession, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
		etudiantServ.createInscription(e, coursSessionServ.getUnCoursSession(idCoursSession));
		return "accueil";
	}
	
	@RequestMapping(value = "/DesinscriptionCours", method = RequestMethod.GET)
	public String desinscription(Model model, @RequestParam("idCoursSession") int idCoursSession, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
		etudiantServ.deleteInscription(e, coursSessionServ.getUnCoursSession(idCoursSession));
		return "accueil";
	}
}
