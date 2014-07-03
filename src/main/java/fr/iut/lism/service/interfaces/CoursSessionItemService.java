package fr.iut.lism.service.interfaces;

import java.util.Date;
import java.util.List;

import fr.iut.lism.CoursSession;
import fr.iut.lism.CoursSessionItem;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Salle;

public interface CoursSessionItemService {
	void createCoursSessionItem(Enseignant e, Salle s, CoursSession cs, String description,  Date date);
	CoursSessionItem getUnCoursSessionItem(int idCoursSessionItem);
	List<CoursSessionItem> getLesCoursSessionItem();
	void updateCoursSessionItem(int idCoursSessionItem, Enseignant e, Salle s, CoursSession c, String descriptionDetail, Date date);
	void deleteCoursSessionItem(int idCoursSessionItem);
}
