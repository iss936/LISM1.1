package fr.iut.lism.controller;

import javax.servlet.http.HttpServletRequest;
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
public class CoursSessionController {
	
	@Autowired protected CoursSessionService coursSessionService;
	@Autowired protected EtudiantService etudiantService;
	
	@RequestMapping(value="/FicheCoursSessionItem", method = RequestMethod.GET)
	public String listCoursSession(Model model, HttpServletRequest request, @RequestParam(value="idCoursSession") int idCoursSession) {
		model.addAttribute("coursSessionItemList", coursSessionService.getUnCoursSession(idCoursSession).getLesCoursSessionItem());
		model.addAttribute("idCoursSession", idCoursSession);
		//reprend l'utilisateur connecté
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");		
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur());
		boolean inscrire = etudiantService.getVerifInscription(idCoursSession, e);
		model.addAttribute("inscrire", inscrire);
		return "coursDetailInscription";
	}
}