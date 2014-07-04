package fr.iut.lism.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.iut.lism.Cours;
import fr.iut.lism.Etudiant;
import fr.iut.lism.Utilisateur;
import fr.iut.lism.service.interfaces.CoursService;
import fr.iut.lism.service.interfaces.CoursSessionService;
import fr.iut.lism.service.interfaces.EtudiantService;

@Controller
public class CoursSessionController {
	
	@Autowired protected CoursSessionService coursSessionService;
	@Autowired protected EtudiantService etudiantService;
	@Autowired protected CoursService coursService;
	
	@RequestMapping(value="/FicheCoursSessionItem", method = RequestMethod.GET)
	public String listCoursSession(Model model, HttpServletRequest request, @RequestParam(value="idCoursSession") int idCoursSession) {
		model.addAttribute("coursSessionItemList", coursSessionService.getUnCoursSession(idCoursSession).getLesCoursSessionItem());
		model.addAttribute("idCoursSession", idCoursSession);
		//reprend l'utilisateur connecté
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");		
		Etudiant e = etudiantService.getUnEtudiant(u.getIdUtilisateur());
		boolean inscrire = etudiantService.getVerifInscription(idCoursSession, e);
		model.addAttribute("inscrire", inscrire);
		return "coursDetailInscription";
	}
	
	@RequestMapping(value = "/addCoursSession", method = RequestMethod.GET)
	public String addCoursSession(Model model) {
		List<Cours> lesCours = coursService.getLesCours();
		model.addAttribute("coursList", lesCours);
		return "frmAddCoursSession";
	}
	
	@RequestMapping(value = "/addCoursSession", method = RequestMethod.POST)
	public String addCoursSession(Model model, @RequestParam("idCours") int idCours, @RequestParam("dateDebut") String dateDebut, @RequestParam("dateFin") String dateFin, @RequestParam("description") String description, @RequestParam("type") String type) throws ParseException {
		Date dateD = new SimpleDateFormat("dd/MM/yyyy").parse(dateDebut);
		Date dateF = new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
		Cours unCours = coursService.getUnCours(idCours);
		coursSessionService.createCoursSession(dateD, dateF, description, unCours, type);
		return addCoursSession(model);
	}
	
	@RequestMapping(value = "/addContenu", method = RequestMethod.POST)
	public String addContenu(Model model, @RequestParam("contenu") MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
	        BufferedOutputStream stream =
	                new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Lionel\\Documents\\workspace\\Spring\\LISM1.1\\" + file.getOriginalFilename())));
	        stream.write(bytes);
	        stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "accueil";
	}
}