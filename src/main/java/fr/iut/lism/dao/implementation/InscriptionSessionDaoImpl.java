package fr.iut.lism.dao.implementation;

import org.springframework.stereotype.Repository;

@Repository
public class InscriptionSessionDaoImpl {

	
//	public static List<Cours> getMatiereSession(int idStudent)
//	{
//		List<Cours> mesCours= null;
//		Session sess = null;
//		try{
////			SELECT etudiant. *
////			FROM etudiant
////			JOIN inscriptionsession ON etudiant.idEtudiant = inscriptionsession.idEtudiant
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			mesCours = sess.createQuery("from InscriptionSession as is"
//					+ "join Etudiant as e ON is.idEtudiant= e.idEtudiant"
//					+ "inner join CoursSession as cs ON  cs.idCoursSession=is.idCoursSession"
//					+ "inner join Cours as c ON c.idCours=cs.idCours"
//					+ "where e.idEtudiant="+idStudent).list();
//			
//			/*
//			 * from Order as order
//    join order.lineItems as item
//    join item.product as product,
//    Catalog as catalog
//    join catalog.prices as price
//*/			tx.commit();
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		finally{
//			sess.close();
//		}
//		return mesCours;
//	}
//	
//	public static void addInscriptionSession(int idEtudiant, int idCoursSession) {
//		Session sess = null;
//		try{
//			sess = HibernateUtil.getSessionFactory().openSession();
//			Transaction tx = sess.beginTransaction();
//			InscriptionSession ins = new InscriptionSession(idEtudiant,idCoursSession);
//			sess.save(ins);
//			tx.commit();
//		}
//		catch(Exception ex){
//		      ex.printStackTrace();
//		      System.out.println("Insertion échouée " + ex.getMessage());
//		}
//		finally{
//			sess.close();
//		}
//	}
}
