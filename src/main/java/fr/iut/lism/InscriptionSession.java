package fr.iut.lism;

import java.io.Serializable;

public class InscriptionSession implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Etudiant etudiant;
	private CoursSession coursSession;
	
	public InscriptionSession(Etudiant etudiant, CoursSession coursSession) {
		this.setEtudiant(etudiant);
		this.setCoursSession(coursSession);
	}
	public InscriptionSession()
	{
		
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
}
