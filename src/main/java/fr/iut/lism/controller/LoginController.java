package fr.iut.lism.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.iut.lism.Cours;
import fr.iut.lism.dao.implementation.CoursDaoImpl;

@Controller
public class LoginController {
	@Resource protected CoursDaoImpl coursDao;
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String list(Model model)
	{
		List<Cours> ls = coursDao.findAll();
		model.addAttribute("courseList",ls);
		return "course/list";
	}

}
