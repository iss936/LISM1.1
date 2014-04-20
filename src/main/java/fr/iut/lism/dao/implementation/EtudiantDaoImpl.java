package fr.iut.lism.dao.implementation;

import org.springframework.stereotype.Repository;

@Repository
public class EtudiantDaoImpl {
	
	/*
	 public static void createEtudiant(String prenom, String nom, String login, String mdp) {
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Etudiant e = new Etudiant(prenom, nom, login, mdp);
			sess.save(e);
			tx.commit();
			}
		catch(Exception e){
			System.out.println("Insertion échouée: " + e.getMessage());
		}
		finally{
			sess.close();
		}
	}
	
	public static Etudiant getUnEtudiant(int idEtudiant) {
		Etudiant e = new Etudiant();
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			e = (Etudiant) sess.createQuery(" from Etudiant where idEtudiant=" + idEtudiant).list().get(0);
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sess.close();
		}
		return e;
	}
	
	public static Etudiant getUnEtudiant(String login, String mdp) {
		Etudiant e = null;
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Query query = sess.createQuery("from Etudiant where login='" + login + "' and mdp='" + mdp + "'");
			e = (Etudiant)query.list().get(0);
			tx.commit();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			sess.close();
		}
		return e;
	}
	
	public static List<Etudiant> getLesEtudiants() {
		List<Etudiant> lesEtudiants = null;
		Session sess = null;
		try{
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			lesEtudiants = sess.createQuery(" from Etudiant").list();
		    tx.commit();
		}
		catch(Exception ex){
		      ex.printStackTrace();
		      System.out.println("Lecture échouée " + ex.getMessage());
		}
		finally{
			sess.close();
		}
		return lesEtudiants;
	}
	
	public static void updateEtudiant(int idEtudiant, String prenom, String nom, String login, String mdp) {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			Etudiant e = (Etudiant)sess.createQuery(" from Etudiant where idEtudiant=" + idEtudiant).list().get(0);
			e.setPrenomEtudiant(prenom);
			e.setNomEtudiant(nom);
			e.setLogin(login);
			e.setMdp(mdp);
			sess.save(e);
			tx.commit();
		}
		catch (Exception ex) {
			System.out.println("Erreur insertion" + ex.getMessage());
		}
		finally {
			sess.close();
		}
	}
	
	public static void deleteEtudiant(int idEtudiant) {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = sess.beginTransaction();
			sess.delete((Etudiant)sess.createQuery(" from Etudiant where idEtudiant=" + idEtudiant).list().get(0));
			tx.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sess.close();
		}
	}
	 */

}
