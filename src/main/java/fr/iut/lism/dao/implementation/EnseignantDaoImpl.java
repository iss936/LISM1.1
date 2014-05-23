package fr.iut.lism.dao.implementation;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import fr.iut.lism.Enseignant;
import fr.iut.lism.dao.interfaces.EnseignantDao;

@Component
public class EnseignantDaoImpl implements EnseignantDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createEnseignant(String prenom, String nom, String login, String mdp) {
		Enseignant e = new Enseignant();
		e.setPrenomEnseignant(prenom);
		e.setNomEnseignant(nom);
		e.setLogin(login);
		e.setMdp(mdp);
		em.persist(e);
	}

	@Override
	public Enseignant getUnEnseignant(int idEnseignant) {
		return em.find(Enseignant.class, idEnseignant);
	}

	@Override
	public Enseignant getUnEnseignant(String login, String mdp) {
		if(!em.createQuery("from Enseignant where login='" + login + "' and mdp='" + mdp + "'").getResultList().isEmpty()) {
			return (Enseignant)em.createQuery("from Enseignant where login='" + login + "' and mdp='" + mdp + "'").getSingleResult();
		} else {
			return null;
		}
	}

	@Override
	public List<Enseignant> getLesEnseignants() {
		return em.createQuery(" from Enseignent").getResultList();
	}

	@Override
	public void updateEnseignant(int idEnseignant, String prenom, String nom, String login, String mdp) {
		Enseignant e = getUnEnseignant(idEnseignant);
		e.setPrenomEnseignant(prenom);
		e.setNomEnseignant(nom);
		e.setLogin(login);
		e.setMdp(mdp);
		em.persist(e);
	}

	@Override
	public void deleteEnseignant(int idEnseignant) {
		Enseignant e = getUnEnseignant(idEnseignant);
		if(e != null) {
			em.remove(e);
		}
	}
}