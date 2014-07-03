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

import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.CoursService;
import fr.iut.lism.service.interfaces.EnseignantService;
import fr.iut.lism.service.interfaces.EtudiantService;
import fr.iut.lism.service.interfaces.UtilisateurService;

@Controller
public class LoginController {

	@Autowired protected EtudiantService etudiantService;
	@Autowired protected EnseignantService enseignantService;
	@Autowired protected CoursService coursService;
	@Autowired protected UtilisateurService utilisateurService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		if(u == null) {
			return "index";
		} else {
			return list2(model);
		}
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String list(Model model, @RequestParam(value="login") String login, @RequestParam(value="mdp") String mdp, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		if(u == null) {
			if(utilisateurService.getUnUtilisateur(login, mdp) != null) {
				session.setAttribute("utilisateur", utilisateurService.getUnUtilisateur(login, mdp));
				return "accueil";
			} else {
				model.addAttribute("erreurs", true);
				return "index";
			}
		} else {
			return list2(model);
		}
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String list2(Model model) {
		return "accueil";
	}
	
	@RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
}
