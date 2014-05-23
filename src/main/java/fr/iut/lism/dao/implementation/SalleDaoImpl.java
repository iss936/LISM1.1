package fr.iut.lism.dao.implementation;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Component;
import fr.iut.lism.Salle;
import fr.iut.lism.dao.interfaces.SalleDao;

@Component
public class SalleDaoImpl implements SalleDao{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@Override
	public void createSalle(String libelle) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Salle s = new Salle(libelle);
		em.persist(s);
		em.getTransaction().commit();
	}

	@Override
	public Salle getUneSalle(int idSalle) {
		em = emf.createEntityManager();
		return em.find(Salle.class, idSalle);
	}

	@Override
	public List<Salle> getLesSalles() {
		em = emf.createEntityManager();
		return em.createQuery(" from Salle").getResultList();
	}

	@Override
	public void updateSalle(int idSalle, String libelleSalle) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Salle s = em.find(Salle.class, idSalle);
		s.setLibelleSalle(libelleSalle);
		em.persist(s);
		em.getTransaction().commit();
	}

	@Override
	public void deleteSalle(int idSalle) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Salle s = em.find(Salle.class, idSalle);
		if(s != null) {
			em.remove(s);
		}
		em.getTransaction().commit();
	}

}
