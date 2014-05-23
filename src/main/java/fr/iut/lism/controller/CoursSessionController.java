package fr.iut.lism.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import fr.iut.lism.dao.implementation.CoursSessionDaoImpl;

@Controller
public class CoursSessionController {
	
	@Resource protected CoursSessionDaoImpl coursSessionDao;
	
	@RequestMapping(value="/FicheCoursSessionItem", method = RequestMethod.GET)
	public String listCoursSession(Model model, @RequestParam(value="idCoursSession") int idCoursSession) {
		model.addAttribute("coursSessionItemList", coursSessionDao.findAll(idCoursSession));
		model.addAttribute("idCoursSession", idCoursSession);
		return "coursDetailInscription";
	}
}