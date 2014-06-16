package fr.iut.lism;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cours_session_item")
public class CoursSessionItem {

	@Id
	private int idCoursSessionItem;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_enseignant")
	private Enseignant enseignant;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_salle")
	private Salle salle;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cours_session")
	private CoursSession coursSession;
	
	@Column(name="description_detail")
	private String descriptionDetail;
	
	@Column(name="date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
	
	public CoursSessionItem(int idCoursSessionItem, Enseignant enseignant, Salle salle, CoursSession coursSession, String descriptionDetail, Date date) {
		this.idCoursSessionItem =  idCoursSessionItem;
		this.enseignant = enseignant;
		this.salle = salle;
		this.coursSession = coursSession;
		this.descriptionDetail = descriptionDetail;
		this.date = date;
	}

	public CoursSessionItem(Enseignant enseignant, Salle salle, CoursSession coursSession, String descriptionDetail, Date date) {
		this.enseignant = enseignant;
		this.salle = salle;
		this.coursSession = coursSession;
		this.descriptionDetail = descriptionDetail;
		this.date = date;
	}
	
	public CoursSessionItem() {
		
	}
	
	public String getDescriptionDetail() {
		return descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
	}

	/**
	 * @return the idCoursSessionItem
	 */
	public int getIdCoursSessionItem() {
		return idCoursSessionItem;
	}

	/**
	 * @param idCoursSessionItem the idCoursSessionItem to set
	 */
	public void setIdCoursSessionItem(int idCoursSessionItem) {
		this.idCoursSessionItem = idCoursSessionItem;
	}

	/**
	 * @return the enseignant
	 */
	public Enseignant getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant the enseignant to set
	 */
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	/**
	 * @return the salle
	 */
	public Salle getSalle() {
		return salle;
	}

	/**
	 * @param salle the salle to set
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}
