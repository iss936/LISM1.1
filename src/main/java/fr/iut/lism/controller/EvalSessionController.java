package fr.iut.lism.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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
import fr.iut.lism.CoursSessionItem;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Etudiant;
import fr.iut.lism.EtudiantCoursEval;
import fr.iut.lism.EvalSession;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.CoursSessionService;
import fr.iut.lism.service.interfaces.EnseignantService;
import fr.iut.lism.service.interfaces.EtudiantCoursEvalService;
import fr.iut.lism.service.interfaces.EtudiantService;
import fr.iut.lism.service.interfaces.EvalSessionService;

@Controller
public class EvalSessionController {
	
	@Autowired protected EtudiantCoursEvalService etudiantCoursEvalService;
	@Autowired protected EvalSessionService evalSessionService;
	@Autowired protected EtudiantService etudiantService;
	@Autowired protected CoursSessionService coursSessionService;
	@Autowired protected EnseignantService enseignantService;
	
	@RequestMapping(value = "/evalSession", method = RequestMethod.GET)
	public String evalSession(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
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
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur()); //Récupération de l'étudiant grâce à l'idUtilisateur
		EvalSession es = evalSessionService.getUneEvalSession(idEvalSession);
		etudiantCoursEvalService.createEtudiantCoursEval(e, es, 0, "Inscrit");
		return "accueil";
	}
	
	@RequestMapping(value = "/listAddEval", method = RequestMethod.GET)
	public String listAddEval(Model model) {
		List<CoursSession> lesCoursSession = coursSessionService.getLesCoursSession();
		model.addAttribute("coursSessionList", lesCoursSession);
		return "listeAddEvalSession";
	}
	
	@RequestMapping(value = "/frmAddEval", method = RequestMethod.GET)
	public String frmAddEval(Model model, @RequestParam("idCoursSession") int idCoursSession) {
		model.addAttribute("idCoursSession", idCoursSession);
		return "frmAddEvalSession"; 
	}
	
	@RequestMapping(value = "/addEval", method = RequestMethod.POST)
	public String addEval(Model model, @RequestParam("dateDebut") String dateDebut, @RequestParam("dateFin") String dateFin, @RequestParam("idCoursSession") int idCoursSession) throws ParseException {
		CoursSession cs = coursSessionService.getUnCoursSession(idCoursSession);
		
		Date dateD = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut);
		Date dateF = new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
		evalSessionService.createEvalSession(dateD, dateF, cs);
		return "accueil";
	}
}
