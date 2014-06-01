package fr.iut.lism.service.implementation;

import java.util.Date;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.iut.lism.CoursSession;
import fr.iut.lism.EvalSession;
import fr.iut.lism.dao.interfaces.EvalSessionDao;
import fr.iut.lism.service.interfaces.EvalSessionService;

@Service
public class EvalSessionServiceImpl implements EvalSessionService{

	@Autowired
	private EvalSessionDao evalSessionDao;

	@Transactional
	public void createEvalSession(Date dateDebut, Date dateFin, CoursSession coursSession) {
		evalSessionDao.createEvalSession(dateDebut, dateFin, coursSession);
	}

	@Transactional
	public EvalSession getUneEvalSession(int idEvalSession) {
		return evalSessionDao.getUneEvalSession(idEvalSession);
	}
}
