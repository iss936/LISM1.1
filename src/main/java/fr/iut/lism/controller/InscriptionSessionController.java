package fr.iut.lism.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.CoursSessionService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class InscriptionSessionController {
	
	@Autowired protected EtudiantService etudiantService;
	@Autowired protected CoursSessionService coursSessionService;
	
	@RequestMapping(value = "/InscriptionCours", method = RequestMethod.POST)
	public String inscription(Model model, @RequestParam("idCoursSession") int idCoursSession, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //R�cup�ration de l'�tudiant gr�ce � l'idUtilisateur
		etudiantService.createInscription(e, coursSessionService.getUnCoursSession(idCoursSession));
		return "accueil";
	}
	
	@RequestMapping(value = "/DesinscriptionCours", method = RequestMethod.GET)
	public String desinscription(Model model, @RequestParam("idCoursSession") int idCoursSession, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //R�cup�ration de l'�tudiant gr�ce � l'idUtilisateur
		etudiantService.deleteInscription(e, coursSessionService.getUnCoursSession(idCoursSession));
		model.addAttribute("estDesinscrit", true);
		return myCourses(model, request);
	}
	
	//voir l'historique des cours � venir et/ou r�aliser
		@RequestMapping(value = "/myCourses", method = RequestMethod.GET)
		public String myCourses(Model model,HttpServletRequest request) {
			HttpSession session = request.getSession();
			Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
			if(u.getRole().equals("etudiant")) {
				Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //R�cup�ration de l'�tudiant gr�ce � l'idUtilisateur
				Set<CoursSession> ls = e.getLesCoursSession(); //on s�lectionne les coursSessions de l'�tudiant
				model.addAttribute("myCourses", ls);
			}
			return "course/mesCours";
		}
}
