package fr.iut.lism.service.interfaces;

import java.util.List;
import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;

public interface EtudiantService {

	void createEtudiant(String prenom, String nom, String login, String mdp);
	Etudiant getUnEtudiant(int idEtudiant);
	Etudiant getUnEtudiant(String login, String mdp);
	List<Etudiant> getLesEtudiants();
	void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp);
	void deleteEtudiant(int idEtudiant);
	void createInscription(Etudiant e, CoursSession cs);
	boolean getVerifInscription(int idCoursSession, Etudiant e);
	void deleteInscription(Etudiant e, CoursSession cs);
}
