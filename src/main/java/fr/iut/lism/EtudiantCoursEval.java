package fr.iut.lism;

import java.io.Serializable;

public class EtudiantCoursEval implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Etudiant etudiant;
	private CoursSession coursSession;
	private EvalSession evalSession;
	private float note;
	private String status;
	
	public EtudiantCoursEval(Etudiant etudiant, CoursSession coursSession, EvalSession evalSession, float note, String status) {
		this.setEtudiant(etudiant);
		this.setCoursSession(coursSession);
		this.setEvalSession(evalSession);
		this.setNote(note);
		this.setStatus(status);
	}
	
	public EtudiantCoursEval() {
		
	}
	
	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}

	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	/**
	 * @return the coursSession
	 */
	public CoursSession getCoursSession() {
		return coursSession;
	}

	/**
	 * @param coursSession the coursSession to set
	 */
	public void setCoursSession(CoursSession coursSession) {
		this.coursSession = coursSession;
	}

	/**
	 * @return the evalSession
	 */
	public EvalSession getEvalSession() {
		return evalSession;
	}

	/**
	 * @param evalSession the evalSession to set
	 */
	public void setEvalSession(EvalSession evalSession) {
		this.evalSession = evalSession;
	}

	/**
	 * @return the note
	 */
	public float getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(float note) {
		this.note = note;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}


