package fr.iut.lism.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.iut.lism.Cours;
import fr.iut.lism.Etudiant;
import fr.iut.lism.dao.implementation.CoursDaoImpl;
import fr.iut.lism.dao.implementation.EtudiantDaoImpl;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class LoginController {
	@Resource protected CoursDaoImpl coursDao;
	@Resource protected EtudiantDaoImpl etudiantDao;
	@Autowired protected EtudiantService etudiantServ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String list(Model model, @RequestParam(value="login") String login, @RequestParam(value="mdp") String mdp, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Etudiant e = (Etudiant) session.getAttribute("etudiant");
		if(e == null) {
			if(etudiantDao.getUnEtudiant(login, mdp) != null) {
				session.setAttribute("etudiant", etudiantDao.getUnEtudiant(login, mdp));
				List<Cours> ls = coursDao.getLesCours();
				model.addAttribute("courseList",ls);
				return "course/list";
			} else {
				return "index";
			}
		} else {
			return list2(model);
		}
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String list2(Model model) {
		List<Cours> ls = coursDao.getLesCours();
		model.addAttribute("courseList",ls);
		return "course/list";
	}
}
