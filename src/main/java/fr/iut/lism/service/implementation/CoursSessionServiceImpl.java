package fr.iut.lism.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.dao.interfaces.CoursSessionDao;
import fr.iut.lism.service.interfaces.CoursSessionService;

@Service
@Transactional
public class CoursSessionServiceImpl implements CoursSessionService{
	
	@Autowired
	private CoursSessionDao coursSessionDao;

	@Override
	public void createCoursSession(Date dateDebut, Date dateFin,
			String description, Cours c, String typeCoursSession) {
		coursSessionDao.createCoursSession(dateDebut, dateFin, description, c, typeCoursSession);
	}

	@Override
	public CoursSession getUnCoursSession(int idCoursSession) {
		return coursSessionDao.getUnCoursSession(idCoursSession);
	}

	@Override
	public List<CoursSession> getLesCoursSession() {
		return coursSessionDao.getLesCoursSession();
	}

	@Override
	public void updateCoursSession(int idCoursSession, Date dateDebut,
			Date dateFin, String description, Cours c, String typeCoursSession) {
		coursSessionDao.updateCoursSession(idCoursSession, dateDebut, dateFin, description, c, typeCoursSession);
	}

	@Override
	public void deleteCoursSession(int idCoursSession) {
		coursSessionDao.deleteCoursSession(idCoursSession);
	}
}
