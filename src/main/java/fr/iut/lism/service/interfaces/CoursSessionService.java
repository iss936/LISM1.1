package fr.iut.lism.service.interfaces;

import java.util.Date;
import java.util.List;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;

public interface CoursSessionService {

	void createCoursSession(Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession);
	CoursSession getUnCoursSession(int idCoursSession);
	List<CoursSession> getLesCoursSession();
	void updateCoursSession(int idCoursSession, Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession);
	void deleteCoursSession(int idCoursSession);
}
