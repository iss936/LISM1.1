package fr.iut.lism.dao.implementation;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import fr.iut.lism.CoursSession;
import fr.iut.lism.CoursSessionItem;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Salle;
import fr.iut.lism.dao.interfaces.CoursSessionItemDao;

@Component
public class CoursSessionItemDaoImpl implements CoursSessionItemDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createCoursSessionItem(Enseignant e, Salle s, CoursSession c,
			String descriptionDetail) {
		CoursSessionItem csi = new CoursSessionItem(e, s, c, descriptionDetail);
		em.persist(csi);
	}

	@Override
	public CoursSessionItem getUnCoursSessionItem(int idCoursSessionItem) {
		return em.find(CoursSessionItem.class, idCoursSessionItem);
	}

	@Override
	public List<CoursSessionItem> getLesCoursSessionsItem() {
		return em.createQuery(" from CoursSessionItem").getResultList();
	}

	@Override
	public void updateCoursSessionItem(int idCoursSessionItem, Enseignant e,
			Salle s, CoursSession c, String descriptionDetail) {
		CoursSessionItem csi = getUnCoursSessionItem(idCoursSessionItem);
		csi.setEnseignant(e);
		csi.setSalle(s);
		csi.setCoursSession(c);
		csi.setDescriptionDetail(descriptionDetail);
	}

	@Override
	public void deleteCoursSessionItem(int idCoursSessionItem) {
		CoursSessionItem csi = getUnCoursSessionItem(idCoursSessionItem);
		if(csi != null)
			em.remove(csi);
	}
}
