package fr.iut.lism.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import fr.iut.lism.Etudiant;
import fr.iut.lism.EtudiantCoursEval;
import fr.iut.lism.EtudiantCoursEvalPk;
import fr.iut.lism.EvalSession;
import fr.iut.lism.dao.interfaces.EtudiantCoursEvalDao;

@Component
public class EtudiantCoursEvalDaoImpl implements EtudiantCoursEvalDao{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;

	@Override
	public void createEtudiantCoursEval(Etudiant e, EvalSession es) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		EtudiantCoursEvalPk pk = new EtudiantCoursEvalPk(e, es);
		EtudiantCoursEval ece = new EtudiantCoursEval(pk);
		em.persist(ece);
		em.getTransaction().commit();
	}
	
	@Override
	public void createEtudiantCoursEval(Etudiant e, EvalSession es, float note,
			String status) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		EtudiantCoursEvalPk pk = new EtudiantCoursEvalPk(e, es);
		EtudiantCoursEval ece = new EtudiantCoursEval(pk, note, status);
		em.persist(ece);
		em.getTransaction().commit();
	}

	@Override
	public List<EtudiantCoursEval> getLesEtudiantCoursEval() {
		em = emf.createEntityManager();
		return em.createQuery("from EtudiantCoursEval").getResultList();
	}
}
