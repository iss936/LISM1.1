package fr.iut.lism.dao.implementation;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;
import fr.iut.lism.dao.interfaces.EtudiantDao;

@Component
public class EtudiantDaoImpl implements EtudiantDao{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Override
	public void createEtudiant(String prenom, String nom, String login, String mdp) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Etudiant e = new Etudiant(prenom, nom, login, mdp);
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Etudiant getUnEtudiant(int idEtudiant) {
		em = emf.createEntityManager();
		return em.find(Etudiant.class, idEtudiant);
	}

	@Override
	public Etudiant getUnEtudiant(String login, String mdp) {
		em = emf.createEntityManager();
		if(!em.createQuery("from Etudiant where login='" + login + "' and mdp='" + mdp + "'").getResultList().isEmpty()) {
			return (Etudiant)em.createQuery("from Etudiant where login='" + login + "' and mdp='" + mdp + "'").getSingleResult();
		} else {
			return null;
		}
	}

	@Override
	public List<Etudiant> getLesEtudiants() {
		em = emf.createEntityManager();
		return em.createQuery(" from Etudiant").getResultList();
	}

	@Override
	public void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Etudiant e = em.find(Etudiant.class, idEtudiant);
		e.setPrenomEtudiant(prenom);
		e.setNomEtudiant(nom);
		e.setLogin(login);
		e.setMdp(mdp);
		em.persist(e);
		em.getTransaction().commit();
	}

	@Override
	public void deleteEtudiant(int idEtudiant) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Etudiant e = getUnEtudiant(idEtudiant);
		if(e != null) {
			em.remove(e);
		}
		em.getTransaction().commit();
	}

	@Override
	public void createInscription(Etudiant e, CoursSession cs) {
		em = emf.createEntityManager();
		em.getTransaction().begin(); //D�but de la transaction
		e.getLesCoursSession().add(cs); //Ajout du CoursSession cs pour l'Etudiant e
		em.persist(em.merge(e)); //Insert dans inscription_session
		em.getTransaction().commit(); //Commit
	}
}
