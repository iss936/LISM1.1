package fr.iut.lism;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CoursSession {

	@Id
	private int idCoursSession;
	
	@Column(name="date_debut")
	private Date dateDebut;
	
	@Column(name="date_fin")
	private Date dateFin;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_cours")
	private Cours cours;
	
	@Column(name="type_cours_session")
	private String typeCoursSession;

//	@OneToMany()
//	private Set<CoursSessionItem> lesCoursSessionItem;
//
//	@OneToMany()
//	private Set<EvalSession> lesEvalSession;
//	
//	@OneToMany()
//	private Set<InscriptionSession> lesInscriptionSession;
	
	public CoursSession(int idCoursSession, Date dateDebut, Date dateFin, String description, Cours cours, String typeCoursSession) {
		this.setIdCoursSession(idCoursSession);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setDescription(description);
		this.setCours(cours);
		this.setTypeCoursSession(typeCoursSession);
	}
	
	public CoursSession(Date dateDebut, Date dateFin, String description, Cours c, String typeCoursSession) {
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
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

//	/**
//	 * @return the lesCoursSessionItem
//	 */
//	public Set<CoursSessionItem> getLesCoursSessionItem() {
//		return lesCoursSessionItem;
//	}
//
//	/**
//	 * @param lesCoursSessionItem the lesCoursSessionItem to set
//	 */
//	public void setLesCoursSessionItem(Set<CoursSessionItem> lesCoursSessionItem) {
//		this.lesCoursSessionItem = lesCoursSessionItem;
//	}
//
//	/**
//	 * @return the lesEvalSession
//	 */
//	public Set<EvalSession> getLesEvalSession() {
//		return lesEvalSession;
//	}
//
//	/**
//	 * @param lesEvalSession the lesEvalSession to set
//	 */
//	public void setLesEvalSession(Set<EvalSession> lesEvalSession) {
//		this.lesEvalSession = lesEvalSession;
//	}
//

//	/**
//	 * @return the lesInscriptionSession
//	 */
//	public Set<InscriptionSession> getLesInscriptionSession() {
//		return lesInscriptionSession;
//	}
//
//	/**
//	 * @param lesInscriptionSession the lesInscriptionSession to set
//	 */
//	public void setLesInscriptionSession(Set<InscriptionSession> lesInscriptionSession) {
//		this.lesInscriptionSession = lesInscriptionSession;
//	}

}
