package fr.iut.lism;

import java.sql.Date;

public class CoursSession {

	private int idCoursSession;
	private Date dateDebut;
	private Date dateFin;
	private String description;
	private int idCours;
	private String typeCoursSession;
	
	public CoursSession(int idCoursSession, Date dateDebut, Date dateFin, int idCoursSessionItem, String description, int idCours, String typeCoursSession) {
		this.setIdCoursSession(idCoursSession);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setDescription(description);
		this.setIdCours(idCours);
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
	public Date getDateDebut() {
		return dateDebut;
	}	

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * @return the idCours
	 */
	public int getIdCours() {
		return idCours;
	}
	
	/**
	 * @param idCours the idCours to set
	 */
	public void setIdCours(int idCours) {
		this.idCours = idCours;
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

}
