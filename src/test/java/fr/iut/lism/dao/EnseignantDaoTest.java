package fr.iut.lism.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.Cours;
import fr.iut.lism.Enseignant;
import fr.iut.lism.dao.implementation.EnseignantDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-junit.xml")
@Transactional
public class EnseignantDaoTest {
	
	@Resource 
	protected EnseignantDaoImpl enseignantDao;
	
	
	@Test
	public void createEnseignantTest()
	{
				//Prepare				
				int nb = enseignantDao.getLesEnseignants().size();
			 
				
				//Perform
				enseignantDao.createEnseignant("Sam", "Stark", "samstark", "admin");
						
				//Post-check
				Assert.assertEquals(nb+1, enseignantDao.getLesEnseignants().size());	
		
	}
	
	//Besoin d'etre transactionelle sinon le test ne fonctionne pas.
	//car dès qu'on le lance le test cela ecrit en base
	// et getunEnseignant en retour plusieurs avec le meme nom donc erreur.
	
	@Test
	public void getEnseignantStringTest()
	{
				//Prepare				
				enseignantDao.createEnseignant("Sam", "Stark", "samstark", "admin");
				Enseignant everif = new Enseignant("Sam", "Stark", "samstark", "admin");
				
				//Perform
				Enseignant e = enseignantDao.getUnEnseignant("samstark", "admin");
						
				//Post-check
				 String nom1 = everif.getNomEnseignant();
				 String nom2 = e.getNomEnseignant();
				
				Assert.assertEquals(nom1, nom2);
		
	}
	
	@Test
	public void updateEnseignantTest()
	{
		//Prepare		
		Enseignant e = enseignantDao.getUnEnseignant(1);
		e.setNomEnseignant("toto");
		String nom = e.getNomEnseignant();
		
		
		//Perform
		enseignantDao.updateEnseignant(e.getIdEnseignant(), e.getPrenomEnseignant(), e.getNomEnseignant(), e.getLogin(), e.getMdp());
		
				
		//Post-check
		Assert.assertEquals(nom, enseignantDao.getUnEnseignant(1).getNomEnseignant());
		
	}
	
	
	//Besoin d'etre transactionelle sinon le test ne fonctionne pas.
	//car dès qu'on le lance le test cela ecrit en base
	// et getunEnseignant en retour plusieurs avec le meme nom donc erreur.
	
	@Test
	public void deleteEnseignantTest()
	{
				//Prepare
		
				enseignantDao.createEnseignant("Sam", "Stark", "samstark", "admin");
				int nb = enseignantDao.getLesEnseignants().size();
				Enseignant e = enseignantDao.getUnEnseignant("samstark", "admin");			
				
				//Perform
				enseignantDao.deleteEnseignant(e.getIdEnseignant());
						
				//Post-check
				Assert.assertEquals(nb-1, enseignantDao.getLesEnseignants().size());
		
	}
	
	
	

}
