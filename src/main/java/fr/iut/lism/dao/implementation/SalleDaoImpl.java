package fr.iut.lism.dao.implementation;

import org.springframework.stereotype.Repository;

@Repository
public class SalleDaoImpl {

//	public static Salle getLaSalle(int idSalle) {
//		Salle salle = new Salle();
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			salle = (Salle) sess.createQuery(" from Salle where idSalle=" + idSalle).list().get(0);
//			tx.commit();
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		finally{
//			sess.close();
//		}
//		return salle;
//	}
}
