package fr.iut.lism.dao.implementation;

import org.springframework.stereotype.Repository;


@Repository
public class CoursSessionItemDaoImpl {

//	public static List<CoursSessionItem> getLesCoursSessionItem(int idCoursSession) {
//		int coursSession = idCoursSession;
//		List<CoursSessionItem> lesCoursSessionItem = null;
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			lesCoursSessionItem = sess.createQuery(" from CoursSessionItem where idCoursSession=" + coursSession).list();
//		    tx.commit();
//		}
//		catch(Exception ex){
//		      ex.printStackTrace();
//		      System.out.println("Lecture échouée " + ex.getMessage());
//		}
//		finally{
//			sess.close();
//		}
//		return lesCoursSessionItem;
//	}
//	
//	public static CoursSessionItem getCoursSessionItem(int idSession) {
//		CoursSessionItem csi = new CoursSessionItem();
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			csi = (CoursSessionItem) sess.createQuery(" from CoursSessionItem where idSession=" + idSession).list().get(0);
//			tx.commit();
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		finally{
//			sess.close();
//		}
//		return csi;
//	}
}
