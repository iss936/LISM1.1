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
	
	@Autowired protected EtudiantCoursEvalService etudiantCoursEvalService;
	@Autowired protected EtudiantService etudiantService;
	
	@RequestMapping(value = "/prochainEval", method = RequestMethod.GET)
	public String prochainEval(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //R�cup�ration de l'�tudiant gr�ce � l'idUtilisateur
//		Set<EvalSession> lesEvals = new HashSet<EvalSession>();
//		if(e.getLesCoursSession().size() > 0) {
//			Iterator<CoursSession> it = e.getLesCoursSession().iterator();
//			while(it.hasNext()) {
//				lesEvals.addAll(it.next().getLesEvalSession());
//			}
//		}
		model.addAttribute("evalSessionList", e.getLesEtudiantCoursEval());
		return "listeEvalSession";
	}
	
	@RequestMapping(value = "/mesResultats", method = RequestMethod.GET)
	public String inscription(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //R�cup�ration de l'�tudiant gr�ce � l'idUtilisateur
		model.addAttribute("etudiantCoursEvalList", e.getLesEtudiantCoursEval());
		return "listeEtudiantCoursEval";
	}
}
