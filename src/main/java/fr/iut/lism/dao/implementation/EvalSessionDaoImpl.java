package fr.iut.lism.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import fr.iut.lism.CoursSession;
import fr.iut.lism.EvalSession;
import fr.iut.lism.dao.interfaces.EvalSessionDao;

@Component
public class EvalSessionDaoImpl implements EvalSessionDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Override
	public void createEvalSession(Date dateDebut, Date dateFin, CoursSession coursSession) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		EvalSession es = new EvalSession(dateDebut, dateFin, coursSession);
		em.persist(em.merge(es));
		em.getTransaction().commit();
	}

	@Override
	public EvalSession getUneEvalSession(int idEvalSession) {
		em = emf.createEntityManager();
		return em.find(EvalSession.class, idEvalSession);
	}
	
	@Override
	public List<EvalSession> getlesEvalSession()
	{
		em = emf.createEntityManager();
		return em.createQuery("from EvalSession").getResultList();
	}
}
