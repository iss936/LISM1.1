package fr.iut.lism.dao.implementation;

import javax.persistence.EntityManager;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class CoursDaoImplTest {
	private EntityManager em;
	
	private CoursDaoImpl cdi;
	
	@Before
	public void init(){
		 em = EasyMock.createMock(EntityManager.class);	
	}
	
	@Test
	public void Test()
	{
		em.persist(EasyMock.anyObject());
		EasyMock.replay(em);
		cdi.createCours("HIST");
		EasyMock.verify(em);		
	}
	

}
