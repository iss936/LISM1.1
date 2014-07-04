package fr.iut.lism.dao.implementation;

import javax.persistence.EntityManager;

import org.easymock.EasyMock;
import org.junit.Before;

public class EnseignantDaoImplTest {
	private EntityManager em;
	
	private EnseignantDaoImpl edi;
	
	@Before
	public void init(){
		 em = EasyMock.createMock(EntityManager.class);	
	}

}
