package fr.iut.lism.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;

import fr.iut.lism.Enseignant;
import fr.iut.lism.Etudiant;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.EnseignantService;
import fr.iut.lism.service.interfaces.EtudiantService;


@Controller
public class ProfilController {
	
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
		} else {
			// en fonction du role, on crée l'objet
			if(u.getRole().equals("etudiant")) {
				//création de l'objet etudiant
				Etudiant e = etudiantServ.getUnEtudiant(u.getIdUtilisateur());
				
				//on verifie la cohérence des variables
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
	
	@RequestMapping(value = "/addContenu", method = RequestMethod.POST)
	public String addContenu(Model model, HttpServletRequest request, @RequestParam("contenu") MultipartFile file) {
		try {
			HttpSession session = request.getSession();
			System.out.println("1 " + Etudiant.class.getResource("lism.sql"));
			System.out.println("2 " + System.getProperty("user.dir"));
			System.out.println("3 " + new File(".").getAbsolutePath());
			System.out.println("4 " + Etudiant.class.getName());
			System.out.println("5 " + session.getServletContext().getContextPath());
		    System.out.println("6 "+ request.getSession().getServletContext().getRealPath("/"));
		    System.out.println("7 " + request.getSession().getServletContext().getContextPath());
		    System.out.println("8 " + request.getSession().getServletContext().getRealPath("/LISM1.1"));
		    System.out.println("9 " + request.getContextPath());
		    System.out.println("10 " + System.getProperty("catalina.home"));
			byte[] bytes = file.getBytes();
	        BufferedOutputStream stream =
	                new BufferedOutputStream(new FileOutputStream(new File(File.separatorChar + file.getOriginalFilename())));
	        stream.write(bytes);
	        stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "accueil";
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

