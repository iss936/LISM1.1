package fr.iut.lism.service.implementation;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.iut.lism.Enseignant;
import fr.iut.lism.dao.interfaces.EnseignantDao;
import fr.iut.lism.service.interfaces.EnseignantService;

@Service
public class EnseignantServiceImpl implements EnseignantService{
	
	@Autowired
	private EnseignantDao enseignantDao;

	@Transactional
	public void createEnseignant(String prenom, String nom, String login, String mdp) {
		enseignantDao.createEnseignant(prenom, nom, login, mdp);
	}

	@Transactional
	public Enseignant getUnEnseignant(int idEnseignant) {
		return enseignantDao.getUnEnseignant(idEnseignant);
	}

	@Transactional
	public Enseignant getUnEnseignant(String login, String mdp) {
		return enseignantDao.getUnEnseignant(login, mdp);
	}

	@Transactional
	public List<Enseignant> getLesEnseignants() {
		return enseignantDao.getLesEnseignants();
	}

	@Transactional
	public void updateEnseignant(int idEnseignant, String prenom, String nom, String login, String mdp) {
		enseignantDao.updateEnseignant(idEnseignant, prenom, nom, login, mdp);
	}

	@Transactional
	public void deleteEnseignant(int idEnseignant) {
		enseignantDao.deleteEnseignant(idEnseignant);
	}
}
