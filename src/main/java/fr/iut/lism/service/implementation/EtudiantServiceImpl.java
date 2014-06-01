package fr.iut.lism.service.implementation;

import java.util.List;
import java.util.Set;

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
	
	@Override
	@Transactional
	public void createEtudiant(String prenom, String nom, String login, String mdp) {
		 etudiantDao.createEtudiant(prenom, nom, login, mdp);
	}

	@Override
	@Transactional
	public Etudiant getUnEtudiant(int idEtudiant) {
		return etudiantDao.getUnEtudiant(idEtudiant);
	}

	@Override
	@Transactional
	public Etudiant getUnEtudiant(String login, String mdp) {
		return etudiantDao.getUnEtudiant(login, mdp);
	}

	@Override
	@Transactional
	public List<Etudiant> getLesEtudiants() {
		return etudiantDao.getLesEtudiants();
	}

	@Override
	@Transactional
	public void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp) {
		etudiantDao.updateEtudiant(idEtudiant, prenom, nom, login, mdp);
	}

	@Override
	@Transactional
	public void deleteEtudiant(int idEtudiant) {
		etudiantDao.deleteEtudiant(idEtudiant);
	}

	@Override
	@Transactional
	public void createInscription(Etudiant e, CoursSession cs) {
		etudiantDao.createInscription(e, cs);
	}
}
