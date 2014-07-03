package fr.iut.lism.dao.interfaces;

import java.util.List;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;

public interface CoursDao {
	
	void createCours(String libelle);
	Cours getUnCours(int idCours);
	List<Cours> getLesCours();
	List<CoursSession> getLesCoursSession(int idCours);
	void updateCours(int idCours, String libelle);
	void deleteCours(int idCours);
	Cours getUnCours(String libelle);
}
