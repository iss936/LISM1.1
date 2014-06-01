package fr.iut.lism.service.interfaces;

import java.util.List;

import fr.iut.lism.Etudiant;
import fr.iut.lism.EtudiantCoursEval;
import fr.iut.lism.EvalSession;

public interface EtudiantCoursEvalService {

	void createEtudiantCoursEval(Etudiant e, EvalSession es);
	void createEtudiantCoursEval(Etudiant e, EvalSession es, float note, String status);
	List<EtudiantCoursEval> getLesEtudiantCoursEval();
}
