package fr.iut.lism.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.Cours;
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
		Assert.assertEquals(5, coursDao.getLesCours().size());
	}
	
	@Test
	public void createCoursTest()
	{
				//Prepare				
				int nb = coursDao.getLesCours().size();
				
				//Perform
				coursDao.createCours("Histoire");
						
				//Post-check
				Assert.assertEquals(nb+1, coursDao.getLesCours().size());	
		
	}
	
	// KO probleme avec getUnCours(String libelle)
	@Test
	public void deleteCoursTest()
	{
				//Prepare
				coursDao.createCours("Maths");
				int nb = coursDao.getLesCours().size();
				Cours c = coursDao.getUnCours("Maths");				
				
				//Perform
				coursDao.deleteCours(c.getIdCours());
						
				//Post-check
				Assert.assertEquals(nb-1, coursDao.getLesCours().size());
		
	}
	
	@Test
	public void updateCoursTest()
	{
				//Prepare		
				Cours c = coursDao.getUnCours(1);
				c.setLibelleCours("toto");
				String libelle = c.getLibelleCours();
				
				
				//Perform
				coursDao.updateCours(c.getIdCours(), c.getLibelleCours());
						
				//Post-check
				Assert.assertEquals(libelle, coursDao.getUnCours(1).getLibelleCours());
		
	}

	@Test
	public void getUnCoursIntTest()
	{
				//Prepare		
					coursDao.createCours(8,"oralB");
								
				//Perform
					Cours c = coursDao.getUnCours(8);		
						
				//Post-check
				Assert.assertEquals(c, coursDao.getUnCours(8));
		
	}
	
	
	// KO probleme avec getUnCours(String libelle)
	
	@Test
	public void getUnCoursStringTest()
	{
				//Prepare		
					coursDao.createCours(9,"Sport");
								
				//Perform
					Cours c = coursDao.getUnCours("Sport");		
						
				//Post-check
				Assert.assertEquals(c, coursDao.getUnCours(8));
		
	}
}
