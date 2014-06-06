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
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.EtudiantCoursEvalService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class EtudiantCoursEvalController {
	
	@Autowired protected EtudiantCoursEvalService etudiantCoursEvalServ;
	@Autowired protected EtudiantService etudiantServ;
	
	@RequestMapping(value = "/mesResultats", method = RequestMethod.GET)
	public String inscription(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
		Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur()); //R�cup�ration de l'�tudiant gr�ce � l'idUtilisateur
		model.addAttribute("etudiantCoursEvalList", e.getLesEtudiantCoursEval());
		return "listeEtudiantCoursEval";
	}
}
