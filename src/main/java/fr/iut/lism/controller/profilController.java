package fr.iut.lism.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Enseignant;
import fr.iut.lism.Etudiant;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.EnseignantService;
import fr.iut.lism.service.interfaces.EtudiantService;


@Controller
public class profilController {
	
	@Autowired protected EtudiantService etudiantServ;
	@Autowired protected EnseignantService enseignantServ;
	
	//Redirige vers la page pour gérer son profil ( modification mdp , mail ...)
	@RequestMapping(value = "/monProfil", method = RequestMethod.GET)
	public String delEnseignant(Model model) {
		
		return "monProfil";
	}
	
	//Permet de Changer le mots de passe de l'utilisateur.
	// 3 variable en entrer : mdp actuel / nouveau mdp / retaper le nouveau mdp
	
	@RequestMapping(value = "/setMdp", method = RequestMethod.POST)
	public String setMdp(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value="oldMdp") String oldMdp, @RequestParam(value="newMdp") String newMdp, @RequestParam(value="newMdpConfirm") String newMdpConfirm) {
		
		//on récupere en session l'utilisateur actuel
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		
		// On vérifie que les variable ne soit pas vide
		if(oldMdp == "" || newMdp == "" || newMdpConfirm == "") {
			
			return "accueil";
		} 
		else {
			// en fonction du role, on crée l'objet
			if(u.getRole().equals("etudiant")) {
				
				//création de l'objet etudiant
				Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur());
				
				//on verifie la cohérence des variables
				if((e.getMdp().toString() == oldMdp) && (newMdp == newMdpConfirm) )
				{
					e.setMdp(newMdp);
					etudiantServ.updateEtudiant(e.getIdEtudiant(), e.getPrenomEtudiant(), e.getNomEtudiant(), e.getLogin(), e.getMdp());	
				}
				else
				{
				  return "accueil";
				}
				
			}
			else{
				Enseignant p = enseignantServ.getUnEnseignant(u.getIdUtilisateur());
				if((p.getMdp().toString() == oldMdp) && (newMdp == newMdpConfirm) )
				{
					p.setMdp(newMdp);
					enseignantServ.updateEnseignant(p.getIdEnseignant(), p.getPrenomEnseignant(), p.getNomEnseignant(), p.getLogin(), p.getMdp());
				}
				else
				{
					return "accueil";
				}
				
			}
			return "accueil";
		}			
			
	}
	
	//Permet de changer l'adresse mail de l'utilisateur
	
	/*
	@RequestMapping(value = "/setMail", method = RequestMethod.POST)
	public String setMail(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value="newMail") String newMail) {
		
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //Récupération de l'utilisateur dans la session
		
		if(u.getRole().equals("etudiant")) {
			
			Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur());
			e.setMail(newMail);
		}
		else{
			
			Enseignant p = enseignantServ.getUnEnseignant(u.getIdUtilisateur());
			p.setMail(newMail);
		}
		
		
		return "";
	}
	
	*/
}

