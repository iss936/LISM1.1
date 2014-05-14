package fr.iut.lism.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.iut.lism.dao.implementation.CoursDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-junit.xml")
public class ContextTest {

	@Resource 
	protected CoursDaoImpl coursDao;
	
	@Test
	public void testSpringConf() 
	{
		
	}
}
