package fr.iut.lism.dao.implementation;

import org.springframework.stereotype.Repository;

import fr.iut.lism.dao.interfaces.CoursDao;

@Repository
public class CoursDaoImpl implements CoursDao{

//	public static void createCours(String libelle) {
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			Cours c = new Cours(libelle);
//			sess.save(c);
//			tx.commit();
//			}
//		catch(Exception e){
//			System.out.println("Insertion échouée: " + e.getMessage());
//		}
//		finally{
//			sess.close();
//		}
//	}
//	
//	public static Cours getUnCours(int idCours) {
//		Cours c = new Cours();
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			c = (Cours) sess.createQuery(" from Cours where idCours=" + idCours).list().get(0);
//			tx.commit();
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		finally{
//			sess.close();
//		}
//		return c;
//	}
//	
//	public static List<Cours> getLesCours() {
//		List<Cours> lesCours = null;
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			lesCours = sess.createQuery(" from Cours").list();
//		    tx.commit();
//		}
//		catch(Exception ex){
//		      ex.printStackTrace();
//		      System.out.println("Lecture échouée " + ex.getMessage());
//		}
//		finally{
//			sess.close();
//		}
//		return lesCours;
//	}
//	
//	public static void updateCours(int idCours, String libelle) {
//		Session sess = null;
//		try {
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			Cours c = (Cours)sess.createQuery(" from Cours where idCours=" + idCours).list().get(0);
//			c.setLibelleCours(libelle);
//			sess.save(c);
//			tx.commit();
//		}
//		catch (Exception ex) {
//			System.out.println("Erreur insertion" + ex.getMessage());
//		}
//		finally {
//			sess.close();
//		}
//	}
//	
//	public static void deleteCours(int idCours) {
//		Session sess = null;
//		try {
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			sess.delete((Cours)sess.createQuery(" from Cours where idCours=" + idCours).list().get(0));
//			tx.commit();
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			sess.close();
//		}
//	}
}
