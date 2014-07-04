package fr.iut.lism.controller;

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
public class ProfilController {
	
	@Autowired protected EtudiantService etudiantServ;
	@Autowired protected EnseignantService enseignantServ;
	
	//Redirige vers la page pour g�rer son profil ( modification mdp , mail ...)
	@RequestMapping(value = "/monProfil", method = RequestMethod.GET)
	public String delEnseignant(Model model) {
		
		return "monProfil";
	}
	
	//Permet de Changer le mots de passe de l'utilisateur.
	// 3 variable en entrer : mdp actuel / nouveau mdp / retaper le nouveau mdp
	
	@RequestMapping(value = "/setMdp", method = RequestMethod.POST)
	public String setMdp(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value="oldMdp") String oldMdp, @RequestParam(value="newMdp") String newMdp, @RequestParam(value="newMdpConfirm") String newMdpConfirm) {
		//on r�cupere en session l'utilisateur actuel
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur"); //R�cup�ration de l'utilisateur dans la session
		
		// On v�rifie que les variable ne soit pas vide
		if(oldMdp == "" || newMdp == "" || newMdpConfirm == "") {
			
			return "accueil";
		} else {
			// en fonction du role, on cr�e l'objet
			if(u.getRole().equals("etudiant")) {
				//cr�ation de l'objet etudiant
				Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur());
				
				//on verifie la coh�rence des variables
				if((e.getMdp().equals(oldMdp)) && (newMdp.equals(newMdpConfirm))) {
					etudiantServ.updateEtudiant(e.getIdEtudiant(), e.getPrenomEtudiant(), e.getNomEtudiant(), e.getLogin(), newMdp);	
				} else {
				  return "accueil";
				}
			} else {
				Enseignant p = enseignantServ.getUnEnseignant(u.getIdUtilisateur());
				if((p.getMdp().equals(oldMdp)) && (newMdp.equals(newMdpConfirm))) {
					enseignantServ.updateEnseignant(p.getIdEnseignant(), p.getPrenomEnseignant(), p.getNomEnseignant(), p.getLogin(), newMdp);
				} else {
					return "accueil";
				}
			}
			return "accueil";
		}
	}
	
	@RequestMapping(value = "/addContenu", method = RequestMethod.GET)
	public String frmAddContenu(Model model) {
		return "frmAddContenu";
	}
}

