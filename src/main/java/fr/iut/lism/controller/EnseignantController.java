package fr.iut.lism.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Salle;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.CoursSessionItemService;
import fr.iut.lism.service.interfaces.CoursSessionService;
import fr.iut.lism.service.interfaces.EnseignantService;
import fr.iut.lism.service.interfaces.SalleService;

@Controller
public class EnseignantController {
	
	@Autowired protected EnseignantService enseignantService;
	@Autowired protected SalleService salleService;
	@Autowired protected CoursSessionService coursSessionService;
	@Autowired protected CoursSessionItemService coursSessionItemService;
	
	@RequestMapping(value = "/addEnseignant", method = RequestMethod.GET)
	public String addEnseignant(Model model) {
		return "frmAddEnseignant";
	}
	
	@RequestMapping(value = "/addEnseignant", method = RequestMethod.POST)
	public String addEnseignant(Model model, @RequestParam(value="nom") String nom, @RequestParam(value="prenom") String prenom, @RequestParam(value="login") String login, @RequestParam(value="mdp") String mdp, @RequestParam(value="confirm") String confirm) {
		if(nom == "" || prenom == "" || login == "" || mdp == "" || confirm == "") {
			return addEnseignant(model);
		} else {
			if(!mdp.equals(confirm)) {
				return addEnseignant(model);
			} else {
				enseignantService.createEnseignant(prenom, nom, login, mdp);
				return delEnseignant(model);
			}
		}
	}
	
	@RequestMapping(value = "/delEnseignant", method = RequestMethod.GET)
	public String delEnseignant(Model model) {
		List<Enseignant> ls = enseignantService.getLesEnseignants();
		model.addAttribute("enseignantList", ls);
		return "listeEnseignant";
	}
	
	@RequestMapping(value = "/delEnseignant", method = RequestMethod.POST)
	public String delEnseignant(Model model, @RequestParam(value="idEnseignant") Integer[] idEnseignant) {
		for(int i = 0; i < idEnseignant.length; i++) {
			enseignantService.deleteEnseignant(idEnseignant[i]);
		}
		return delEnseignant(model);
	}
	
	@RequestMapping(value = "/AddCoursSessionItem", method = RequestMethod.GET)
	public String AddCoursSessionItem(Model model) {
		
		List<Enseignant> lsE = enseignantService.getLesEnseignants();
		model.addAttribute("enseignantList", lsE);
		
		List<Salle> lsS = salleService.getLesSalles();
		model.addAttribute("salleList", lsS);
		
		List<CoursSession> lsCS = coursSessionService.getLesCoursSession();
		model.addAttribute("coursSessionList", lsCS);

		return "frmAddCoursSessionItem";
	}
	
	@RequestMapping(value = "/AddCoursSessionItem", method = RequestMethod.POST)
	public String AddCoursSessionItem(Model model, 
			@RequestParam(value="choixProf") int choixProf, 
			@RequestParam(value="choixCoursSession") int choixCoursSession,
			@RequestParam(value="choixSalle") int choixSalle, 
			@RequestParam(value="date") String dateString, 
			@RequestParam(value="description") String description) throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		Enseignant p = enseignantService.getUnEnseignant(choixProf);
		Salle s = salleService.getUneSalle(choixSalle);
		CoursSession cs = coursSessionService.getUnCoursSession(choixCoursSession);
		 coursSessionItemService.createCoursSessionItem(p, s, cs, description, date);
		return AddCoursSessionItem(model);
	}

	@RequestMapping(value = "/myPlanning", method = RequestMethod.GET)
	public String myPlanning(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
		Enseignant unEnseignant = (Enseignant) enseignantService.getUnEnseignant(u.getIdUtilisateur()); //R�cup�ration de l'enseignant gr�ce � l'idUtilisateur
		model.addAttribute("coursSessionItemList", unEnseignant.getLesCoursSessionItem());
		return "planningEnseignant";
	}
}
