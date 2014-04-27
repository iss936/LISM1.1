package fr.iut.lism;

import java.util.Set;

public class CoursSession {

	private int idCoursSession;
	private java.util.Date dateDebut;
	private java.util.Date dateFin;
	private String description;
	private Cours cours;
	private String typeCoursSession;
	private Set<CoursSessionItem> lesCoursSessionItem;
	private Set<EvalSession> lesEvalSession;
	private Set<EtudiantCoursEval> lesEtudiantCoursEval;
	private Set<InscriptionSession> lesInscriptionSession;
	
	public CoursSession(int idCoursSession, java.util.Date dateDebut, java.util.Date dateFin, int idCoursSessionItem, String description, Cours cours, String typeCoursSession) {
		this.setIdCoursSession(idCoursSession);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setDescription(description);
		this.setCours(cours);
		this.setTypeCoursSession(typeCoursSession);
	}
	
	public CoursSession() {
		
	}

	/**
	 * @return the idCoursSession
	 */
	public int getIdCoursSession() {
		return idCoursSession;
	}

	/**
	 * @param idCoursSession the idCoursSession to set
	 */
	public void setIdCoursSession(int idCoursSession) {
		this.idCoursSession = idCoursSession;
	}

	/**
	 * @return the dateDebut
	 */
	public java.util.Date getDateDebut() {
		return dateDebut;
	}	

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(java.util.Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public java.util.Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(java.util.Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public String getTypeCoursSession() {
		return typeCoursSession;
	}
	
	/**
	 * @param typeCoursSession the tyCoursSession to set
	 */
	public void setTypeCoursSession(String typeCoursSession) {
		this.typeCoursSession = typeCoursSession;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cours
	 */
	public Cours getCours() {
		return cours;
	}

	/**
	 * @param cours the cours to set
	 */
	public void setCours(Cours cours) {
		this.cours = cours;
	}

	/**
	 * @return the lesCoursSessionItem
	 */
	public Set<CoursSessionItem> getLesCoursSessionItem() {
		return lesCoursSessionItem;
	}

	/**
	 * @param lesCoursSessionItem the lesCoursSessionItem to set
	 */
	public void setLesCoursSessionItem(Set<CoursSessionItem> lesCoursSessionItem) {
		this.lesCoursSessionItem = lesCoursSessionItem;
	}

	/**
	 * @return the lesEvalSession
	 */
	public Set<EvalSession> getLesEvalSession() {
		return lesEvalSession;
	}

	/**
	 * @param lesEvalSession the lesEvalSession to set
	 */
	public void setLesEvalSession(Set<EvalSession> lesEvalSession) {
		this.lesEvalSession = lesEvalSession;
	}

	/**
	 * @return the lesEtudiantCoursEval
	 */
	public Set<EtudiantCoursEval> getLesEtudiantCoursEval() {
		return lesEtudiantCoursEval;
	}

	/**
	 * @param lesEtudiantCoursEval the lesEtudiantCoursEval to set
	 */
	public void setLesEtudiantCoursEval(Set<EtudiantCoursEval> lesEtudiantCoursEval) {
		this.lesEtudiantCoursEval = lesEtudiantCoursEval;
	}

	/**
	 * @return the lesInscriptionSession
	 */
	public Set<InscriptionSession> getLesInscriptionSession() {
		return lesInscriptionSession;
	}

	/**
	 * @param lesInscriptionSession the lesInscriptionSession to set
	 */
	public void setLesInscriptionSession(Set<InscriptionSession> lesInscriptionSession) {
		this.lesInscriptionSession = lesInscriptionSession;
	}

}
