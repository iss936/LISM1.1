package fr.iut.lism.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.iut.lism.Cours;
import fr.iut.lism.dao.interfaces.CoursDao;

@Repository
public class CoursDaoImpl implements CoursDao{

	
	private SessionFactory sessionFactory;
	
	public void createCours(String libelle) {
		Cours c = new Cours(libelle);
		sessionFactory.getCurrentSession().save(c);
	}
	
	public Cours getUnCours(int idCours) {
		return (Cours) sessionFactory.getCurrentSession().load(Cours.class, idCours);
	}

	public List<Cours> getLesCours() {
		return sessionFactory.getCurrentSession().createQuery(" from Cours").list();
	}
	
	public void updateCours(int idCours, String libelle) {
		Cours c = getUnCours(idCours);
		c.setLibelleCours(libelle);
		sessionFactory.getCurrentSession().save(c);
	}
	
	public void deleteCours(int idCours) {
		Cours c = getUnCours(idCours);
		if(c != null)
			sessionFactory.getCurrentSession().delete(c);
	}
}
