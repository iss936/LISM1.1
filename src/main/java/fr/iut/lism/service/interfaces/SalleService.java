package fr.iut.lism.service.interfaces;

import java.util.List;

import fr.iut.lism.Salle;

public interface SalleService {

	void createSalle(String libelle);
	Salle getUneSalle(int idSalle);
	List<Salle> getLesSalles();
	void updateSalle(int idSalle, String libelleSalle);
	void deleteSalle(int idSalle);
}
