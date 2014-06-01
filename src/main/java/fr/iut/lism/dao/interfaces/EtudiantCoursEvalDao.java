package fr.iut.lism.dao.interfaces;

import java.util.List;

import fr.iut.lism.Etudiant;
import fr.iut.lism.EvalSession;
import fr.iut.lism.EtudiantCoursEval;

public interface EtudiantCoursEvalDao {

	void createEtudiantCoursEval(Etudiant e, EvalSession es);
	void createEtudiantCoursEval(Etudiant e, EvalSession es, float note, String status);
	List<EtudiantCoursEval> getLesEtudiantCoursEval();
}
