package fr.iut.lism.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.CoursSession;
import fr.iut.lism.CoursSessionItem;
import fr.iut.lism.Enseignant;
import fr.iut.lism.Salle;
import fr.iut.lism.dao.interfaces.CoursSessionItemDao;
import fr.iut.lism.service.interfaces.CoursSessionItemService;


@Service
@Transactional
public class CoursSessionItemServiceImpl implements CoursSessionItemService  {

	@Autowired
	private CoursSessionItemDao coursSessionItemDao;

	@Override
	public void createCoursSessionItem(Enseignant e, Salle s, CoursSession cs,
			String description, Date date) {
		coursSessionItemDao.createCoursSessionItem(e, s, cs, description, date);
	}

	@Override
	public CoursSessionItem getUnCoursSessionItem(int idCoursSessionItem) {
		return coursSessionItemDao.getUnCoursSessionItem(idCoursSessionItem);
	}

	@Override
	public List<CoursSessionItem> getLesCoursSessionItem() {
		return coursSessionItemDao.getLesCoursSessionItem();
	}

	@Override
	public void updateCoursSessionItem(int idCoursSessionItem, Enseignant e,
			Salle s, CoursSession c, String descriptionDetail, Date date) {
		coursSessionItemDao.updateCoursSessionItem(idCoursSessionItem, e, s, c, descriptionDetail, date);
	}

	@Override
	public void deleteCoursSessionItem(int idCoursSessionItem) {
		coursSessionItemDao.deleteCoursSessionItem(idCoursSessionItem);
	}
}
