package fr.iut.lism.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import fr.iut.lism.dao.interfaces.CoursSessionDao;

@Repository
public class CoursSessionDaoImpl implements CoursSessionDao{

//	public static List<CoursSession> getLesCoursSession(int idCours) {
//		int courss = idCours;
//		List<CoursSession> lesCoursSession = null;
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			lesCoursSession = sess.createQuery(" from CoursSession where idCours=" + courss).list();
//		    tx.commit();
//		}
//		catch(Exception ex){
//		      ex.printStackTrace();
//		      System.out.println("Lecture échouée " + ex.getMessage());
//		}
//		finally{
//			sess.close();
//		}
//		return lesCoursSession;
//	}
//	
//	public static CoursSession getUnCoursSession(int idCoursSession) {
//		CoursSession cs = new CoursSession();
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			cs = (CoursSession) sess.createQuery(" from CoursSession where idCoursSession=" + idCoursSession).list().get(0);
//			tx.commit();
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		finally{
//			sess.close();
//		}
//		return cs;
//	}
}
