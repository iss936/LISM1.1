package fr.iut.lism.service.interfaces;

import java.util.List;
import fr.iut.lism.Cours;

public interface CoursService {

	void createCours(String libelle);
	Cours getUnCours(int idCours);
	List<Cours> getLesCours();
	void updateCours(int idCours, String libelle);
	void deleteCours(int idCours);
}
