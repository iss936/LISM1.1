package fr.iut.lism.dao.implementation;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.dao.interfaces.CoursDao;

@Component
public class CoursDaoImpl implements CoursDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createCours(String libelle) {
		Cours c = new Cours(libelle);
		em.persist(c);
	}
	
	@Override
	public Cours getUnCours(int idCours) {
		return em.find(Cours.class, idCours);
	}

	@Override
	public List<Cours> getLesCours() {
		return em.createQuery(" from Cours").getResultList();
	}
	
	@Override
	public List<CoursSession> getLesCoursSession(int idCours) {
		return em.createQuery(" from CoursSession where id_cours = " + idCours).getResultList();
	}
	
	@Override
	public void updateCours(int idCours, String libelle) {
		Cours c = getUnCours(idCours);
		c.setLibelleCours(libelle);
	}
	
	@Override
	public void deleteCours(int idCours) {
		Cours c = getUnCours(idCours);
		if(c != null) {
			em.remove(c);
		}
	}
}
