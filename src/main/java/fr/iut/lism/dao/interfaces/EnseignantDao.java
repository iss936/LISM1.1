package fr.iut.lism.dao.interfaces;

import java.util.List;

import fr.iut.lism.Enseignant;

public interface EnseignantDao {

	public void createEnseignant(String prenom, String nom, String login, String mdp);
	public Enseignant getUnEnseignant(int idEnseignant);
	public Enseignant getUnEnseignant(String login, String mdp);
	public List<Enseignant> getLesEnseignants();
	public void updateEnseignant(int idEnseignant, String prenom, String nom, String login, String mdp);
	public void deleteEnseignant(int idEnseignant);
}
