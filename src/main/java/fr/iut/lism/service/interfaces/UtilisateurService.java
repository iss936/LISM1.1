package fr.iut.lism.service.interfaces;

import java.util.List;

import fr.iut.lism.Utilisateur;

public interface UtilisateurService {

	Utilisateur getUnUtilisateur(int idUtilisateur);
	Utilisateur getUnUtilisateur(String login, String mdp);
	List<Utilisateur> getLesUtilisateurs();
}
