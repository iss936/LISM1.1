package fr.iut.lism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import fr.iut.lism.service.interfaces.CoursSessionService;

@Controller
public class CoursSessionController {
	
	@Autowired protected CoursSessionService coursSessionServ;
	
	@RequestMapping(value="/FicheCoursSessionItem", method = RequestMethod.GET)
	public String listCoursSession(Model model, @RequestParam(value="idCoursSession") int idCoursSession) {
		model.addAttribute("coursSessionItemList", coursSessionServ.getUnCoursSession(idCoursSession).getLesCoursSessionItem());
		model.addAttribute("idCoursSession", idCoursSession);
		return "coursDetailInscription";
	}
}