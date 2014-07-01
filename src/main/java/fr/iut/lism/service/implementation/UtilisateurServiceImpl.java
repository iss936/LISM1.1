package fr.iut.lism.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.Utilisateur;
import fr.iut.lism.dao.interfaces.UtilisateurDao;
import fr.iut.lism.service.interfaces.UtilisateurService;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Override
	public Utilisateur getUnUtilisateur(int idUtilisateur) {
		return utilisateurDao.getUnUtilisateur(idUtilisateur);
	}

	@Override
	public Utilisateur getUnUtilisateur(String login, String mdp) {
		return utilisateurDao.getUnUtilisateur(login, mdp);
	}

	@Override
	public List<Utilisateur> getLesUtilisateurs() {
		return utilisateurDao.getLesUtilisateurs();
	}
}
