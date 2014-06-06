package fr.iut.lism.controller;

import java.util.List;
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
import fr.iut.lism.Cours;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.CoursService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class CoursController {
	
	@Autowired protected CoursService coursService;
	@Autowired protected EtudiantService etudiantServ;
	
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
	
	//voir l'historique des cours à venir et/ou réaliser
	@RequestMapping(value = "/myCourses", method = RequestMethod.GET)
	public String myCourses(Model model,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		if(u.getRole().equals("etudiant")) {
			Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
			Set<CoursSession> ls = e.getLesCoursSession(); //on sélectionne les coursSessions de l'étudiant
			model.addAttribute("myCourses", ls);
		}
		return "course/mesCours";
	}
}
