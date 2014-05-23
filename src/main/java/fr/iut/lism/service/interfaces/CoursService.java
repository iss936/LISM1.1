package fr.iut.lism.service.interfaces;

import java.util.List;
import fr.iut.lism.Cours;

public interface CoursService {

	public void createCours(String libelle);
	public Cours getUnCours(int idCours);
	public List<Cours> getLesCours();
	public void updateCours(int idCours, String libelle);
	public void deleteCours(int idCours);
}
