package fr.iut.lism.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.iut.lism.Salle;
import fr.iut.lism.dao.interfaces.SalleDao;

@Repository
public class SalleDaoImpl implements SalleDao{

	@Override
	public void createSalle(String libelle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Salle getUneSalle(int idSalle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salle> getLesSalles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSalle(int idSalle, String libelleSalle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSalle(int idSalle) {
		// TODO Auto-generated method stub
		
	}

}
