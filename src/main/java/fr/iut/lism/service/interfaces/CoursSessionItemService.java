package fr.iut.lism.service.interfaces;

import java.util.Date;

import fr.iut.lism.CoursSession;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Salle;

public interface CoursSessionItemService {
	void createCoursSessionItem(Enseignant e, Salle s, CoursSession cs, String description,  Date date);

}
