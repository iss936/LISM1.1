package fr.iut.lism.dao.interfaces;

import java.util.Date;
import java.util.List;

import fr.iut.lism.CoursSession;
import fr.iut.lism.EvalSession;

public interface EvalSessionDao {

	void createEvalSession(Date dateDebut, Date dateFin, CoursSession coursSession);
	EvalSession getUneEvalSession(int idEvalSession);
	List<EvalSession> getlesEvalSession();
	
}
