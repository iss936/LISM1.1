package fr.iut.lism.dao.interfaces;

import java.util.Date;
import java.util.List;

import fr.iut.lism.Cours;
import fr.iut.lism.CoursSession;
import fr.iut.lism.CoursSessionItem;

public interface CoursSessionDao {

	public void createCoursSession(Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession);
	public CoursSession getUnCoursSession(int idCoursSession);
	public List<CoursSession> findAll();
	public void updateCoursSession(int idCoursSession, Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession);
	public void deleteCoursSession(int idCoursSession);
	public Cours getCours(int id);
	public List<CoursSessionItem> findAll(int idCoursSession);
}