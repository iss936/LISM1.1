package fr.iut.lism.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import fr.iut.lism.Utilisateur;
import fr.iut.lism.dao.interfaces.UtilisateurDao;

@Component
public class UtilisateurDaoImpl implements UtilisateurDao{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Override
	public Utilisateur getUnUtilisateur(int idUtilisateur) {
		em = emf.createEntityManager();
		return em.find(Utilisateur.class, idUtilisateur);
	}

	@Override
	public Utilisateur getUnUtilisateur(String login, String mdp) {
		em = emf.createEntityManager();
		if(!em.createQuery("from Utilisateur where login='" + login + "' and mdp='" + mdp + "'").getResultList().isEmpty()) {
			return (Utilisateur)em.createQuery("from Utilisateur where login='" + login + "' and mdp='" + mdp + "'").getSingleResult();
		} else {
			return null;
		}
	}

	@Override
	public List<Utilisateur> getLesUtilisateurs() {
		em = emf.createEntityManager();
		return em.createQuery(" from Utilisateur").getResultList();
	}
}
