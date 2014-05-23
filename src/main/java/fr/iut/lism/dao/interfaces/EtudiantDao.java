package fr.iut.lism.dao.interfaces;

import java.util.List;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;

public interface EtudiantDao {

	public void createEtudiant(String prenom, String nom, String login, String mdp);
	public Etudiant getUnEtudiant(int idEtudiant);
	public Etudiant getUnEtudiant(String login, String mdp);
	public List<Etudiant> getLesEtudiants();
	public void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp);
	public void deleteEtudiant(int idEtudiant);
	public void createInscription(Etudiant e, CoursSession cs);
}
