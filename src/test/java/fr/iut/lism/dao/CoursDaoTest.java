package fr.iut.lism.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.dao.implementation.CoursDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-junit.xml")
@Transactional
public class CoursDaoTest {

	@Resource 
	protected CoursDaoImpl coursDao;
	
	@Test
	public void testFindAll() 
	{
		int val=5;
		Assert.assertEquals(5, coursDao.findAll().size());
		
	}
}
