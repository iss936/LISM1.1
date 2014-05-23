package fr.iut.lism.service.implementation;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;
import fr.iut.lism.dao.interfaces.EtudiantDao;
import fr.iut.lism.service.interfaces.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService{

	@Autowired
	private EtudiantDao etudiantDao;
	
	@Transactional
	public void createEtudiant(String prenom, String nom, String login, String mdp) {
		etudiantDao.createEtudiant(prenom, nom, login, mdp);
	}

	@Transactional
	public Etudiant getUnEtudiant(int idEtudiant) {
		return etudiantDao.getUnEtudiant(idEtudiant);
	}

	@Transactional
	public Etudiant getUnEtudiant(String login, String mdp) {
		return etudiantDao.getUnEtudiant(login, mdp);
	}

	@Transactional
	public List<Etudiant> getLesEtudiants() {
		return etudiantDao.getLesEtudiants();
	}

	@Transactional
	public void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp) {
		etudiantDao.updateEtudiant(idEtudiant, prenom, nom, login, mdp);
	}

	@Transactional
	public void deleteEtudiant(int idEtudiant) {
		etudiantDao.deleteEtudiant(idEtudiant);
	}

	@Transactional
	public void createInscription(Etudiant e, CoursSession cs) {
		etudiantDao.createInscription(e, cs);
		
	}
}
