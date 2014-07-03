package fr.iut.lism.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.lism.Etudiant;
import fr.iut.lism.EtudiantCoursEval;
import fr.iut.lism.EvalSession;
import fr.iut.lism.dao.interfaces.EtudiantCoursEvalDao;
import fr.iut.lism.service.interfaces.EtudiantCoursEvalService;

@Service
@Transactional
public class EtudiantCoursEvalServiceImpl implements EtudiantCoursEvalService{
	
	@Autowired
	private EtudiantCoursEvalDao etudiantCoursEvalDao;

	@Override
	public void createEtudiantCoursEval(Etudiant e, EvalSession es) {
		etudiantCoursEvalDao.createEtudiantCoursEval(e, es);
	}
	
	@Override
	public void createEtudiantCoursEval(Etudiant e, EvalSession es, float note,
			String status) {
		etudiantCoursEvalDao.createEtudiantCoursEval(e, es, note, status);
	}
	
	@Override
	public EtudiantCoursEval getUnEtudiantCoursEval(Etudiant e, EvalSession es) {
		return etudiantCoursEvalDao.getUnEtudiantCoursEval(e, es);
	}

	@Override
	public List<EtudiantCoursEval> getLesEtudiantCoursEval() {
		return etudiantCoursEvalDao.getLesEtudiantCoursEval();
	}
	
	@Override
	public void updateEtudiantCoursEval(Etudiant e, EvalSession es, float note, String status) {
		etudiantCoursEvalDao.updateEtudiantCoursEval(e, es, note, status);
	}
}
