package fr.iut.lism;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cours")
public class Cours {

	
	@Id
	private int idCours;
	
	@Column(name="libelle_cours")
	private String libelleCours;
	
	@OneToMany(mappedBy="cours", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<CoursSession> lesCoursSession = new HashSet<CoursSession>();
	
	
	public Cours(int idCours, String libelle) {
		this.setIdCours(idCours);
		this.setLibelleCours(libelle);
	}
	
	public Cours(String libelle) {
		this.setLibelleCours(libelle);
	}
	
	public Cours() {
		
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

	/**
	 * @return the libelle
	 */
	public String getLibelleCours() {
		return libelleCours;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelleCours(String libelle) {
		this.libelleCours = libelle;
	}

	/**
	 * @return the lesCoursSession
	 */
	public Set<CoursSession> getLesCoursSession() {
		return lesCoursSession;
	}

	/**
	 * @param lesCoursSession the lesCoursSession to set
	 */
	public void setLesCoursSession(Set<CoursSession> lesCoursSession) {
		this.lesCoursSession = lesCoursSession;
	}
}
