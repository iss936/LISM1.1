package fr.iut.lism.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import fr.iut.lism.CoursSession;
import fr.iut.lism.CoursSessionItem;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Salle;
import fr.iut.lism.dao.interfaces.CoursSessionItemDao;

@Component
public class CoursSessionItemDaoImpl implements CoursSessionItemDao{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Override
	public void createCoursSessionItem(Enseignant e, Salle s, CoursSession c, String descriptionDetail, Date date) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		CoursSessionItem csi = new CoursSessionItem(e, s, c, descriptionDetail, date);
		em.persist(csi);
		em.getTransaction().commit();
	}

	@Override
	public CoursSessionItem getUnCoursSessionItem(int idCoursSessionItem) {
		em = emf.createEntityManager();
		return em.find(CoursSessionItem.class, idCoursSessionItem);
	}

	@Override
	public List<CoursSessionItem> getLesCoursSessionsItem() {
		em = emf.createEntityManager();
		return em.createQuery(" from CoursSessionItem").getResultList();
	}

	@Override
	public void updateCoursSessionItem(int idCoursSessionItem, Enseignant e, Salle s, CoursSession c, String descriptionDetail, Date date) {
		em  = emf.createEntityManager();
		CoursSessionItem csi = getUnCoursSessionItem(idCoursSessionItem);
		csi.setEnseignant(e);
		csi.setSalle(s);
		csi.setCoursSession(c);
		csi.setDescriptionDetail(descriptionDetail);
		csi.setDate(date);
	}

	@Override
	public void deleteCoursSessionItem(int idCoursSessionItem) {
		CoursSessionItem csi = getUnCoursSessionItem(idCoursSessionItem);
		if(csi != null) {
			em.remove(csi);
		}
	}
}