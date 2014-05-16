package fr.iut.lism.dao.implementation;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.CoursSessionItem;
import fr.iut.lism.dao.interfaces.CoursSessionDao;

@Component
public class CoursSessionDaoImpl implements CoursSessionDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void createCoursSession(Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession) {
		CoursSession cs = new CoursSession(dateDebut, dateFin, description, c, typeCoursSession);
		em.persist(cs);
	}

	@Override
	public CoursSession getUnCoursSession(int idCoursSession) {
		return em.find(CoursSession.class, idCoursSession);
	}

	@Override
	public List<CoursSessionItem> findAll(int idCoursSession) {
		// TODO Auto-generated method stub
		return em.createQuery(" from CoursSessionItem where id_cours_session = " + idCoursSession).getResultList();
	}
	
	@Override
	public void updateCoursSession(int idCoursSession, Date dateDebut,
			Date dateFin, String description, Cours c, String typeCoursSession) {
		CoursSession cs = getUnCoursSession(idCoursSession);
		cs.setDateDebut(dateDebut);
		cs.setDateFin(dateFin);
		cs.setDescription(description);
		cs.setCours(c);
		cs.setTypeCoursSession(typeCoursSession);
	}

	@Override
	public void deleteCoursSession(int idCoursSession) {
		// TODO Auto-generated method stub
		
	}
	
	public Cours getCours(int id)
	{
		return em.find(Cours.class, id);
	}

	@Override
	public List<CoursSession> findAll() {
		return em.createQuery("from CoursSession").getResultList();
	}
}
