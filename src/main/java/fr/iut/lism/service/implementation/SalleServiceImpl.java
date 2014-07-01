package fr.iut.lism.service.implementation;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.iut.lism.Salle;
import fr.iut.lism.dao.interfaces.SalleDao;
import fr.iut.lism.service.interfaces.SalleService;

@Service
@Transactional
public class SalleServiceImpl implements SalleService{

	@Autowired
	private SalleDao salleDao;

	@Override
	public void createSalle(String libelle) {
		salleDao.createSalle(libelle);
	}

	@Override
	public Salle getUneSalle(int idSalle) {
		return salleDao.getUneSalle(idSalle);
	}

	@Override
	public List<Salle> getLesSalles() {
		return salleDao.getLesSalles();
	}

	@Override
	public void updateSalle(int idSalle, String libelleSalle) {
		salleDao.updateSalle(idSalle, libelleSalle);
	}

	@Override
	public void deleteSalle(int idSalle) {
		salleDao.deleteSalle(idSalle);
	}
}
