package fr.iut.lism.dao.interfaces;

import java.util.List;

import fr.iut.lism.Salle;

public interface SalleDao {

	public void createSalle(String libelle);
	public Salle getUneSalle(int idSalle);
	public List<Salle> getLesSalles();
	public void updateSalle(int idSalle, String libelleSalle);
	public void deleteSalle(int idSalle);
}
