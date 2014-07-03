package fr.iut.lism.service.implementation;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.iut.lism.dao.interfaces.CoursDao;

public class CoursServiceImplTest {
	
	private CoursServiceImpl csi;
	
	@Autowired
	private CoursDao cd;
	
	@Before
	public void init(){
		 csi = new CoursServiceImpl();
		 cd = EasyMock.createMock(CoursDao.class);
	}
	
	@Test
	public void createCoursTest() {
		//EasyMock.expect(CoursDao);
		cd.createCours("Geo");
		EasyMock.replay(cd);
		csi.createCours("Histoire");
		EasyMock.verify(cd);	
	}
	

}
