package fr.iut.lism.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iut.lism.CoursSession;
import fr.iut.lism.EvalSession;
import fr.iut.lism.dao.interfaces.EvalSessionDao;
import fr.iut.lism.service.interfaces.EvalSessionService;

@Service
@Transactional
public class EvalSessionServiceImpl implements EvalSessionService{

	@Autowired
	private EvalSessionDao evalSessionDao;

	@Override
	public void createEvalSession(Date dateDebut, Date dateFin, CoursSession coursSession) {
		evalSessionDao.createEvalSession(dateDebut, dateFin, coursSession);
	}

	@Override
	public EvalSession getUneEvalSession(int idEvalSession) {
		return evalSessionDao.getUneEvalSession(idEvalSession);
	}
	
	@Override
	public List<EvalSession> getLesEvalSession() {
		return evalSessionDao.getlesEvalSession();
	}
}
