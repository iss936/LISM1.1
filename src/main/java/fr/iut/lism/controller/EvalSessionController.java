package fr.iut.lism.controller;

import java.util.HashSet;
import java.util.Iterator;
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
import fr.iut.lism.EvalSession;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.EtudiantCoursEvalService;
import fr.iut.lism.service.interfaces.EtudiantService;
import fr.iut.lism.service.interfaces.EvalSessionService;

@Controller
public class EvalSessionController {
	
	@Autowired protected EtudiantCoursEvalService etudiantCoursEvalServ;
	@Autowired protected EvalSessionService evalSessionServ;
	@Autowired protected EtudiantService etudiantServ;
	
	@RequestMapping(value = "/evalSession", method = RequestMethod.GET)
	public String evalSession(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
		Set<EvalSession> lesEvals = new HashSet<EvalSession>();
		Iterator<CoursSession> it = e.getLesCoursSession().iterator();
		while(it.hasNext()) {
			lesEvals.addAll(it.next().getLesEvalSession());
		}
		model.addAttribute("evalSessionList", lesEvals);
		return "listeEvalSessionIns";
	}
	
	@RequestMapping(value = "/inscriptionEval", method = RequestMethod.GET)
	public String inscriptionEval(Model model, @RequestParam("idEvalSession") int idEvalSession, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
		EvalSession es = evalSessionServ.getUneEvalSession(idEvalSession);
		etudiantCoursEvalServ.createEtudiantCoursEval(e, es, 0, "Inscrit");
		return "accueil";
	}
}
