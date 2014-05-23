package fr.iut.lism.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Cours;
import fr.iut.lism.dao.implementation.CoursDaoImpl;
import fr.iut.lism.dao.implementation.EtudiantDaoImpl;

@Controller
public class LoginController {
	@Resource protected CoursDaoImpl coursDao;
	@Resource protected EtudiantDaoImpl etudiantDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String list(Model model, @RequestParam(value="login") String login, @RequestParam(value="mdp") String mdp)
	{
		if(etudiantDao.getUnEtudiant(login, mdp) != null) {
			List<Cours> ls = coursDao.getLesCours();
			model.addAttribute("courseList",ls);
			return "course/list";
		}
		else
			return "index";
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String list2(Model model) {
		List<Cours> ls = coursDao.getLesCours();
		model.addAttribute("courseList",ls);
		return "course/list";
	}
}
