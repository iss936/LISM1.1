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
import fr.iut.lism.service.interfaces.CoursService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class LoginController {

	@Autowired protected EtudiantService etudiantServ;
	@Autowired protected CoursService coursServ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String list(Model model, @RequestParam(value="login") String login, @RequestParam(value="mdp") String mdp, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Etudiant e = (Etudiant) session.getAttribute("etudiant");
		if(e == null) {
			if(etudiantServ.getUnEtudiant(login, mdp) != null) {
				session.setAttribute("etudiant", etudiantServ.getUnEtudiant(login, mdp));
				return "accueil";
			} else {
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
}
