package fr.iut.lism.dao.implementation;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;
import fr.iut.lism.dao.interfaces.EtudiantDao;

@Component
public class EtudiantDaoImpl implements EtudiantDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createEtudiant(String prenom, String nom, String login, String mdp) {
		Etudiant e = new Etudiant(prenom, nom, login, mdp);
		em.persist(e);
	}

	@Override
	public Etudiant getUnEtudiant(int idEtudiant) {
		return em.find(Etudiant.class, idEtudiant);
	}

	@Override
	public Etudiant getUnEtudiant(String login, String mdp) {
		if(em.createQuery("from Etudiant where login='" + login + "' and mdp='" + mdp + "'").getResultList().size() > 0)
			return (Etudiant)em.createQuery("from Etudiant where login='" + login + "' and mdp='" + mdp + "'").getSingleResult();
		else
			return null;
	}

	@Override
	public List<Etudiant> getLesEtudiants() {
		return em.createQuery(" from Etudiant").getResultList();
	}

	@Override
	public void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp) {
		Etudiant e = getUnEtudiant(idEtudiant);
		e.setPrenomEtudiant(prenom);
		e.setNomEtudiant(nom);
		e.setLogin(login);
		e.setMdp(mdp);
		em.persist(e);
	}

	@Override
	public void deleteEtudiant(int idEtudiant) {
		Etudiant e = getUnEtudiant(idEtudiant);
		if(e != null)
			em.remove(e);
	}

	@Override
	public void createInscription(Etudiant e, CoursSession cs) {
		Etudiant e1 = new Etudiant("test", "test", "test", "test");
		Cours c = em.find(Cours.class, 1);
		CoursSession cs1 = new CoursSession(new Date(), new Date(), "test", c, "test");
		Set<CoursSession> lesCoursSession = new HashSet<CoursSession>();
		lesCoursSession.add(cs1);
		e1.setLesCoursSession(lesCoursSession);
		em.persist(e1);
	}
}
