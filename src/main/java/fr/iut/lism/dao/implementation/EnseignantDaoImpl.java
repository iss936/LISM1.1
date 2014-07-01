package fr.iut.lism.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import fr.iut.lism.Enseignant;
import fr.iut.lism.dao.interfaces.EnseignantDao;

@Component
public class EnseignantDaoImpl implements EnseignantDao{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Override
	public void createEnseignant(String prenom, String nom, String login, String mdp) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Enseignant e = new Enseignant(prenom, nom, login, mdp);
		em.persist(e);
		em.getTransaction().commit();
	}

	@Override
	public Enseignant getUnEnseignant(int idEnseignant) {
		em = emf.createEntityManager();
		return em.find(Enseignant.class, idEnseignant);
	}

	@Override
	public Enseignant getUnEnseignant(String login, String mdp) {
		em = emf.createEntityManager();
		if(!em.createQuery("from Enseignant where login='" + login + "' and mdp='" + mdp + "'").getResultList().isEmpty()) {
			return (Enseignant)em.createQuery("from Enseignant where login='" + login + "' and mdp='" + mdp + "'").getSingleResult();
		} else {
			return null;
		}
	}

	@Override
	public List<Enseignant> getLesEnseignants() {
		em = emf.createEntityManager();
		return em.createQuery(" from Enseignant").getResultList();
	}

	@Override
	public void updateEnseignant(int idEnseignant, String prenom, String nom, String login, String mdp) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Enseignant e = em.find(Enseignant.class, idEnseignant);
		e.setPrenomEnseignant(prenom);
		e.setNomEnseignant(nom);
		e.setLogin(login);
		e.setMdp(mdp);
		em.getTransaction().commit();
	}

	@Override
	public void deleteEnseignant(int idEnseignant) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Enseignant e = em.find(Enseignant.class, idEnseignant);
		if(e != null) {
			em.remove(e);
		}
		em.getTransaction().commit();
	}
}