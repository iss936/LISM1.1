package fr.iut.lism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Enseignant;
import fr.iut.lism.service.interfaces.EnseignantService;

@Controller
public class EnseignantController {
	
	@Autowired protected EnseignantService enseignantServ;
	
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
				enseignantServ.createEnseignant(prenom, nom, login, mdp);
				return "accueil";
			}
		}
	}
	
	@RequestMapping(value = "/delEnseignant", method = RequestMethod.GET)
	public String delEnseignant(Model model) {
		List<Enseignant> ls = enseignantServ.getLesEnseignants();
		model.addAttribute("enseignantList", ls);
		return "listeEnseignant";
	}
	
	@RequestMapping(value = "/delEnseignant", method = RequestMethod.POST)
	public String delEnseignant(Model model, @RequestParam(value="idEnseignant") Integer[] idEnseignant) {
		for(int i = 0; i < idEnseignant.length; i++) {
			enseignantServ.deleteEnseignant(idEnseignant[i]);
		}
		return "accueil";
	}
	
}
