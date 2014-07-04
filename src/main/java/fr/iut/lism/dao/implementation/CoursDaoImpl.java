package fr.iut.lism.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.dao.interfaces.CoursDao;

@Component
public class CoursDaoImpl implements CoursDao{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Override
	public void createCours(String libelle) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Cours c = new Cours(libelle);
		em.persist(c);
		em.getTransaction().commit();
	}
	
	@Override
	public void createCours(int idCours, String libelle) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Cours c = new Cours(idCours,libelle);
		em.persist(c);
		em.getTransaction().commit();
	}
	
	@Override
	public Cours getUnCours(int idCours) {
		em = emf.createEntityManager();
		return em.find(Cours.class, idCours);
	}

	@Override
	public List<Cours> getLesCours() {
		em = emf.createEntityManager();
		return em.createQuery(" from Cours").getResultList();
	}
	
	@Override
	public List<CoursSession> getLesCoursSession(int idCours) {
		return em.createQuery(" from CoursSession where id_cours = " + idCours).getResultList();
	}
	
	@Override
	public void updateCours(int idCours, String libelle) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Cours c = em.find(Cours.class, idCours);
		c.setLibelleCours(libelle);
		em.getTransaction().commit();
	}
	
	@Override
	public void deleteCours(int idCours) {
		Cours c = getUnCours(idCours);
		if(c != null) {
			em.remove(c);
		}
	}

	@Override
	public Cours getUnCours(String libelle) {
		em = emf.createEntityManager();
		return em.find(Cours.class, libelle);
	}
}
