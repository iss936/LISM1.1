package fr.iut.lism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Etudiant;
import fr.iut.lism.service.interfaces.EnseignantService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class EtudiantController {
	
	@Autowired protected EnseignantService enseignantService;
	@Autowired protected EtudiantService etudiantService;
	
	@RequestMapping(value = "/addEtudiant", method = RequestMethod.GET)
	public String addEtudiant(Model model) {
		return "frmAddEtudiant";
	}
	
	@RequestMapping(value = "/addEtudiant", method = RequestMethod.POST)
	public String addEtudiant(Model model, @RequestParam(value="nom") String nom, @RequestParam(value="prenom") String prenom, @RequestParam(value="login") String login, @RequestParam(value="mdp") String mdp, @RequestParam(value="confirm") String confirm) {
		if("".equals(nom) || "".equals(prenom) || "".equals(login) || "".equals(mdp) || "".equals(confirm)) {
			return addEtudiant(model);
		} else {
			if(!mdp.equals(confirm)) {
				return addEtudiant(model);
			} else {
				etudiantService.createEtudiant(prenom, nom, login, mdp);
				return "accueil";
			}
		}
	}
	
	@RequestMapping(value = "/delEtudiant", method = RequestMethod.GET)
	public String delEtudiant(Model model) {
		List<Etudiant> ls = etudiantService.getLesEtudiants();
		model.addAttribute("etudiantList", ls);
		return "listeEtudiant";
	}
	
	@RequestMapping(value="/delEtudiant", method = RequestMethod.POST)
	public String delEtudiant(Model model, @RequestParam(value="idEtudiant") Integer[] idEtudiant) {
		for(int i = 0; i < idEtudiant.length; i++) {
			etudiantService.deleteEtudiant(idEtudiant[i]);
		}
		return "accueil";
	}
}
