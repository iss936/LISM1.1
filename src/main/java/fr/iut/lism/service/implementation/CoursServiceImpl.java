package fr.iut.lism.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.iut.lism.Cours;
import fr.iut.lism.dao.interfaces.CoursDao;
import fr.iut.lism.service.interfaces.CoursService;

@Service
@Transactional
public class CoursServiceImpl implements CoursService{
	
	@Autowired
	private CoursDao coursDao;

	@Override
	public void createCours(String libelle) {
		coursDao.createCours(libelle);
	}

	@Override
	public Cours getUnCours(int idCours) {
		return coursDao.getUnCours(idCours);
	}

	@Override
	public List<Cours> getLesCours() {
		return coursDao.getLesCours();
	}

	@Override
	public void updateCours(int idCours, String libelle) {
		coursDao.updateCours(idCours, libelle);
	}

	@Override
	public void deleteCours(int idCours) {
		coursDao.deleteCours(idCours);
	}
}
