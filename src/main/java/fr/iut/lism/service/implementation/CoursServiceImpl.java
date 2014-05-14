package fr.iut.lism.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.Cours;
import fr.iut.lism.dao.interfaces.CoursDao;
import fr.iut.lism.service.interfaces.CoursService;

@Service
public class CoursServiceImpl implements CoursService{
	
	private CoursDao coursDao;

	@Transactional
	public void createCours(String libelle) {
		coursDao.createCours(libelle);
		
	}

	@Transactional
	public Cours getUnCours(int idCours) {
		return coursDao.getUnCours(idCours);
	}

	@Transactional
	public List<Cours> getLesCours() {
		return coursDao.findAll();
	}

	@Transactional
	public void updateCours(int idCours, String libelle) {
		coursDao.updateCours(idCours, libelle);
		
	}

	@Transactional
	public void deleteCours(int idCours) {
		coursDao.deleteCours(idCours);
		
	}
}
