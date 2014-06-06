package fr.iut.lism.dao;

import java.util.Set;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;
import fr.iut.lism.dao.implementation.CoursSessionDaoImpl;
import fr.iut.lism.dao.implementation.EtudiantDaoImpl;
import fr.iut.lism.service.interfaces.EtudiantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-junit.xml")
@Transactional()
public class EtudiantDaoTest {

	@Resource 
	protected EtudiantDaoImpl etudiantDao;
	
	@Autowired protected EtudiantService etudiant;
	
	@Resource
	protected CoursSessionDaoImpl coursSessionDao;
	
	@Test
	public void testFindAll() 
	{
		Assert.assertEquals(3, etudiantDao.getLesEtudiants().size());
	}
	
	@Test
	public void testCreateEtudiant()
	{
		etudiant.createEtudiant("test", "test", "ttest", "ttest");
//		System.out.println(etudiant.getUnEtudiant("ttest", "ttest").getIdEtudiant());
		Assert.assertNotNull(etudiant.getUnEtudiant("ttest", "ttest"));
	}
	
	@Test
	public void testCreateInscriptionSession()
	{
		Etudiant e = etudiantDao.getUnEtudiant(2);
		CoursSession cs = coursSessionDao.getUnCoursSession(1);
		int taille = e.getLesCoursSession().size();
		etudiant.createInscription(e, cs);
		Assert.assertEquals(taille+1, e.getLesCoursSession().size());
	}
	
	@Test
	public void testGetVerifInscription()
	{
		//prepare
		int idEtudiant=3;
		boolean result=true;
		
		//perform
		boolean possible = etudiant.getVerifInscription(2, etudiant.getUnEtudiant(idEtudiant));
		
		//post-check
		
		Assert.assertEquals(true, possible);
		
//	for (CoursSession coursSession : list) {
//			
//			System.out.println(coursSession.getDescription());
//			
//		}
		
	}
	
	
	
	
	
}
