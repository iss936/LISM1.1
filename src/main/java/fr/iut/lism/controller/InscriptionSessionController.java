package fr.iut.lism.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import fr.iut.lism.dao.implementation.CoursSessionDaoImpl;
import fr.iut.lism.dao.implementation.EtudiantDaoImpl;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class InscriptionSessionController {
	@Resource protected EtudiantDaoImpl etudiantDao;
	@Autowired protected EtudiantService etudiantServ;
	@Resource protected CoursSessionDaoImpl coursSessionDao;
	
	@RequestMapping(value = "/InscriptionCours", method = RequestMethod.POST)
	public String inscription(Model model, @RequestParam("idCoursSession") int idCoursSession)
	{
		etudiantServ.createEtudiant("test", "test", "test", "test");
//		etudiantServ.createInscription(e, coursSessionDao.getUnCoursSession(idCoursSession));
		return "course/list";
	}

}
