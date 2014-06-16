package fr.iut.lism.dao.implementation;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Component;
import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.dao.interfaces.CoursSessionDao;

@Component
public class CoursSessionDaoImpl implements CoursSessionDao{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;

	@Override
	public void createCoursSession(Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		CoursSession cs = new CoursSession(dateDebut, dateFin, description, c, typeCoursSession);
		em.persist(cs);
		em.getTransaction().commit();
	}

	@Override
	public CoursSession getUnCoursSession(int idCoursSession) {
		em = emf.createEntityManager();
//		return em.find(CoursSession.class, idCoursSession);
		System.out.println(idCoursSession);
		return (CoursSession) em.createQuery("from CoursSession where idCoursSession = " + idCoursSession).getSingleResult();
	}

	@Override
	public List<CoursSession> getLesCoursSession() {
		em = emf.createEntityManager();
		return em.createQuery("from CoursSession").getResultList();
	}
	
	@Override
	public void updateCoursSession(int idCoursSession, Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		CoursSession cs = getUnCoursSession(idCoursSession);
		cs.setDateDebut(dateDebut);
		cs.setDateFin(dateFin);
		cs.setDescription(description);
		cs.setCours(c);
		cs.setTypeCoursSession(typeCoursSession);
		em.persist(cs);
		em.getTransaction().commit();
	}

	@Override
	public void deleteCoursSession(int idCoursSession) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		CoursSession cs = getUnCoursSession(idCoursSession);
		if(cs != null) {
			em.remove(cs);
		}
		em.getTransaction().commit();
	}
}
