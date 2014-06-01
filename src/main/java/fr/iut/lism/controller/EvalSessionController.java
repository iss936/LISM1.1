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
import fr.iut.lism.EtudiantCoursEval;
import fr.iut.lism.EtudiantCoursEvalPk;
import fr.iut.lism.EvalSession;
import fr.iut.lism.service.interfaces.EtudiantCoursEvalService;
import fr.iut.lism.service.interfaces.EvalSessionService;

@Controller
public class EvalSessionController {
	
	@Autowired protected EtudiantCoursEvalService etudiantCoursEvalServ;
	@Autowired protected EvalSessionService evalSessionServ;
	
	@RequestMapping(value = "/prochainEval", method = RequestMethod.GET)
	public String prochainEval(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Etudiant e = (Etudiant) session.getAttribute("etudiant"); //Récupération de l'étudiant dans la session
		Set<EvalSession> lesEvals = new HashSet<EvalSession>();
		Iterator<CoursSession> it = e.getLesCoursSession().iterator();
		while(it.hasNext()) {
			lesEvals.addAll(it.next().getLesEvalSession());
		}
		model.addAttribute("evalSessionList", lesEvals);
		return "listeEvalSession";
	}
	
	@RequestMapping(value = "/evalSession", method = RequestMethod.GET)
	public String evalSession(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Etudiant e = (Etudiant) session.getAttribute("etudiant"); //Récupération de l'étudiant dans la session
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
		Etudiant e = (Etudiant) session.getAttribute("etudiant"); //Récupération de l'étudiant dans la session
		EvalSession es = evalSessionServ.getUneEvalSession(idEvalSession);
		EtudiantCoursEvalPk pk = new EtudiantCoursEvalPk(e, es);
		EtudiantCoursEval ece = new EtudiantCoursEval(pk);
		e.addEtudiantCoursEval(ece);
		return "accueil";
	}
}
