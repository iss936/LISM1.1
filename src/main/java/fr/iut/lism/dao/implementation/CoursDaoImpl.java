package fr.iut.lism.dao.implementation;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.iut.lism.Cours;
import fr.iut.lism.dao.interfaces.CoursDao;

@Component
public class CoursDaoImpl implements CoursDao{
	
	@PersistenceContext
	private EntityManager em;
	
//	public void createCours(String libelle) {
//		Cours c = new Cours(libelle);
//		em.persist(c);
//	}
//	
//	public Cours getUnCours(int idCours) {
//		return em.find(Cours.class, idCours);
//	}

	public List<Cours> findAll() {
		return em.createQuery(" from Cours").getResultList();
	}
	
	public void updateCours(int idCours, String libelle) {
		Cours c = getUnCours(idCours);
		c.setLibelleCours(libelle);
	}
	
	public void deleteCours(int idCours) {
		Cours c = getUnCours(idCours);
		if(c != null)
			em.remove(c);
	}

	@Override
	public void createCours(String libelle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cours getUnCours(int idCours) {
		// TODO Auto-generated method stub
		return null;
	}
}
