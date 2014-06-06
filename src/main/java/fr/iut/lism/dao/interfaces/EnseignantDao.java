package fr.iut.lism.dao.interfaces;

import java.util.List;

import fr.iut.lism.Enseignant;

public interface EnseignantDao {

	void createEnseignant(String prenom, String nom, String login, String mdp);
	Enseignant getUnEnseignant(int idEnseignant);
	Enseignant getUnEnseignant(String login, String mdp);
	List<Enseignant> getLesEnseignants();
	void updateEnseignant(int idEnseignant, String prenom, String nom, String login, String mdp);
	void deleteEnseignant(int idEnseignant);
}
