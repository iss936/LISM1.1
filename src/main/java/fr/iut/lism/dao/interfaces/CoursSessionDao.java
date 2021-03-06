package fr.iut.lism.dao.interfaces;

import java.util.Date;
import java.util.List;
import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;

public interface CoursSessionDao {

	void createCoursSession(Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession);
	CoursSession getUnCoursSession(int idCoursSession);
	List<CoursSession> getLesCoursSession();
	void updateCoursSession(int idCoursSession, Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession);
	void deleteCoursSession(int idCoursSession);
}