package fr.iut.lism;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
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
	
	public CoursSessionItem(int idCoursSessionItem, Enseignant enseignant, Salle salle, CoursSession coursSession, String descriptionDetail) {
		this.setIdCoursSessionItem(idCoursSessionItem);
		this.setEnseignant(enseignant);
		this.setSalle(salle);
		this.setCoursSession(coursSession);
		this.setDescriptionDetail(descriptionDetail);
	}

	public CoursSessionItem(Enseignant enseignant, Salle salle, CoursSession coursSession, String descriptionDetail) {
		this.setEnseignant(enseignant);
		this.setEnseignant(enseignant);
		this.setSalle(salle);
		this.setDescriptionDetail(descriptionDetail);
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

}
