package fr.iut.lism.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iut.lism.dao.interfaces.CoursDao;
import fr.iut.lism.service.interfaces.CoursService;

@Service
public class CoursServiceImpl implements CoursService{
	
	@Autowired
	private CoursDao coursDao;
	
}
