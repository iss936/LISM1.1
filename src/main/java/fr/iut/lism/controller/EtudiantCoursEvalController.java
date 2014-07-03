package fr.iut.lism.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.CoursSessionItem;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Etudiant;
import fr.iut.lism.EtudiantCoursEval;
import fr.iut.lism.EvalSession;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.EnseignantService;
import fr.iut.lism.service.interfaces.EtudiantCoursEvalService;
import fr.iut.lism.service.interfaces.EtudiantService;
import fr.iut.lism.service.interfaces.EvalSessionService;

@Controller
public class EtudiantCoursEvalController {
	
	@Autowired protected EtudiantCoursEvalService etudiantCoursEvalService;
	@Autowired protected EtudiantService etudiantService;
	@Autowired protected EnseignantService enseignantService;
	@Autowired protected EvalSessionService evalSessionService;
	
	@RequestMapping(value = "/prochainEval", method = RequestMethod.GET)
	public String prochainEval(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
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
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
		model.addAttribute("etudiantCoursEvalList", e.getLesEtudiantCoursEval());
		return "listeEtudiantCoursEval";
	}
	
	@RequestMapping(value = "/addNote", method = RequestMethod.GET)
	public String deposNotes(Model model,  HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Enseignant unEnseignant = enseignantService.getUnEnseignant(u.getIdUtilisateur());
		Set<EtudiantCoursEval> lesEval = new HashSet<EtudiantCoursEval>();
		
		Iterator<CoursSessionItem> it = unEnseignant.getLesCoursSessionItem().iterator();
		while (it.hasNext()) {
			CoursSessionItem coursSessionItem = (CoursSessionItem) it.next();
			Iterator<EvalSession> it2 = coursSessionItem.getCoursSession().getLesEvalSession().iterator();
			while (it2.hasNext()) {
				EvalSession evalSession = (EvalSession) it2.next();
				Iterator<EtudiantCoursEval> it3 = evalSession.getLesEtudiantCoursEval().iterator();
				while (it3.hasNext()) {
					EtudiantCoursEval etudiantCoursEval = (EtudiantCoursEval) it3.next();
					if(etudiantCoursEval.getStatus().equals("Passé")) {
						lesEval.add(etudiantCoursEval);
					}
				}
			}
		}
		model.addAttribute("lesEvalsList", lesEval);
		return "listeEval";
	}
	
	@RequestMapping(value = "/frmAddNote", method = RequestMethod.GET)
	public String frmAddNote(Model model, @RequestParam("idEtudiant") int idEtudiant, @RequestParam("idEvalSession") int idEvalSession) {
		Etudiant unEtudiant = etudiantService.getUnEtudiant(idEtudiant);
		EvalSession uneEvalSession = evalSessionService.getUneEvalSession(idEvalSession);
		EtudiantCoursEval uneEval = etudiantCoursEvalService.getUnEtudiantCoursEval(unEtudiant, uneEvalSession);
		model.addAttribute("uneEval", uneEval);
		return "frmAddNote";
	}
	
	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
	public String addNote(Model model, @RequestParam("idEtudiant") int idEtudiant, @RequestParam("idEvalSession") int idEvalSession,  @RequestParam("note") float note, HttpServletRequest request, HttpServletResponse response) {
		Etudiant unEtudiant = etudiantService.getUnEtudiant(idEtudiant);
		EvalSession uneEvalSession = evalSessionService.getUneEvalSession(idEvalSession);
		etudiantCoursEvalService.updateEtudiantCoursEval(unEtudiant, uneEvalSession, note, "Noté");
		return deposNotes(model, request , response);
	}
}
