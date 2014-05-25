package fr.iut.lism.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import fr.iut.lism.dao.implementation.CoursSessionDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-junit.xml")
@Transactional
public class CoursSessionDaoTest {

	@Resource 
	protected CoursSessionDaoImpl coursSessionDao;
	
	@Test
	public void testFindAll() 
	{
		Assert.assertEquals(3, coursSessionDao.getLesCoursSession().size());
	}
	
//	@Test
//	public void testRelation() 
//	{
//		String s= "Informatique";
//		Assert.assertEquals(s, coursSessionDao.getCours().getLibelleCours());
//	}
	
}
