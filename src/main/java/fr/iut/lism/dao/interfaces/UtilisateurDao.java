package fr.iut.lism.dao.interfaces;

import java.util.List;

import fr.iut.lism.Utilisateur;

public interface UtilisateurDao {

	Utilisateur getUnUtilisateur(int idUtilisateur);
	Utilisateur getUnUtilisateur(String login, String mdp);
	List<Utilisateur> getLesUtilisateurs();
}
