package fr.iut.lism.dao.interfaces;

import java.util.List;
import java.util.Set;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;

public interface EtudiantDao {

	void createEtudiant(String prenom, String nom, String login, String mdp);
	Etudiant getUnEtudiant(int idEtudiant);
	Etudiant getUnEtudiant(String login, String mdp);
	List<Etudiant> getLesEtudiants();
	void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp);
	void deleteEtudiant(int idEtudiant);
	void createInscription(Etudiant e, CoursSession cs);
	Set<CoursSession> getMesInscriptions(int idEtudiant);
}
