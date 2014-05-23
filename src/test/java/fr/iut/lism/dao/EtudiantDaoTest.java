package fr.iut.lism.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Etudiant;
import fr.iut.lism.dao.implementation.CoursDaoImpl;
import fr.iut.lism.dao.implementation.CoursSessionDaoImpl;
import fr.iut.lism.dao.implementation.EtudiantDaoImpl;
import fr.iut.lism.service.implementation.EtudiantServiceImpl;
import fr.iut.lism.service.interfaces.EtudiantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-junit.xml")
@Transactional
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
		System.out.println(etudiant.getUnEtudiant("ttest", "ttest").getIdEtudiant());
		Assert.assertNotNull(etudiant.getUnEtudiant("ttest", "ttest"));
	}
	
	@Test
	public void testCreateInscriptionSession()
	{
		Etudiant e = etudiantDao.getUnEtudiant(1);
		CoursSession cs = coursSessionDao.getUnCoursSession(1);
		etudiant.createInscription(e, cs);
	}
}
