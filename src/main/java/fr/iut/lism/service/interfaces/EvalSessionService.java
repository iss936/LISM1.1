package fr.iut.lism.service.interfaces;

import java.util.Date;

import fr.iut.lism.CoursSession;
import fr.iut.lism.EvalSession;

public interface EvalSessionService {

	void createEvalSession(Date dateDebut, Date dateFin, CoursSession coursSession);
	EvalSession getUneEvalSession(int idEvalSession);
}
