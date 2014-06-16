package fr.iut.lism;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="cours_session")
public class CoursSession {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cours_session")
	private int idCoursSession;
	
	@Column(name="date_debut")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name="date_fin")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_cours")
	private Cours cours;
	
	@Column(name="type_cours_session")
	private String typeCoursSession;

	@OneToMany(mappedBy="coursSession", cascade=CascadeType.ALL)
	@OrderBy(clause = "id_cours_session ASC")
	private List<CoursSessionItem> lesCoursSessionItem = new ArrayList<CoursSessionItem>();

	@OneToMany(mappedBy="coursSession", cascade=CascadeType.ALL)
	private Set<EvalSession> lesEvalSession = new HashSet<EvalSession>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="inscription_session",
			joinColumns=@JoinColumn(name="id_cours_session"),
			inverseJoinColumns=@JoinColumn(name="id_etudiant"))
	private Set<Etudiant> lesEtudiant = new HashSet<Etudiant>();
	
	public CoursSession(int idCoursSession, Date dateDebut, Date dateFin, String description, Cours cours, String typeCoursSession) {
		this.idCoursSession = idCoursSession;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.cours = cours;
		this.typeCoursSession = typeCoursSession;
	}
	
	public CoursSession(Date dateDebut, Date dateFin, String description, Cours cours, String typeCoursSession) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.cours = cours;
		this.typeCoursSession = typeCoursSession;
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

	/**
	 * @return the lesEtudiant
	 */
	public Set<Etudiant> getLesEtudiant() {
		return lesEtudiant;
	}

	/**
	 * @param lesEtudiant the lesEtudiant to set
	 */
	public void setLesEtudiant(Set<Etudiant> lesEtudiant) {
		this.lesEtudiant = lesEtudiant;
	}

	/**
	 * @return the lesCoursSessionItem
	 */
	public List<CoursSessionItem> getLesCoursSessionItem() {
		return lesCoursSessionItem;
	}

	/**
	 * @param lesCoursSessionItem the lesCoursSessionItem to set
	 */
	public void setLesCoursSessionItem(List<CoursSessionItem> lesCoursSessionItem) {
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
}
