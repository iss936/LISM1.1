package fr.iut.lism.dao.implementation;

import java.util.List;

import fr.iut.lism.Enseignant;
import fr.iut.lism.dao.interfaces.EnseignantDao;

public class EnseignantDaoImpl implements EnseignantDao{

	@Override
	public void createEnseignant(String prenom, String nom, String login,
			String mdp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enseignant getUnEnseignant(int idEnseignant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant getUnEnseignant(String login, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> getLesEnseignants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEnseignant(int idEnseignant, String prenom, String nom,
			String login, String mdp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEnseignant(int idEnseignant) {
		// TODO Auto-generated method stub
		
	}

}
